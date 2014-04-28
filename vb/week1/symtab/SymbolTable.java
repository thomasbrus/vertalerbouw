package vb.week1.symtab;

import java.util.*;

public class SymbolTable<Entry extends IdEntry> {
  private Integer currentLevel;
  private HashMap<String, List<Entry>> table;

  /**
   * Constructor.
   * @ensures  this.currentLevel() == -1
   */
  public SymbolTable() {
    this.currentLevel = -1;
    this.table = new HashMap<String, List<Entry>>();
  }

  /**
   * Opens a new scope.
   * @ensures this.currentLevel() == old.currentLevel()+1;
   */
  public void openScope()  {
    this.currentLevel += 1;
  }

  /**
   * Closes the current scope. All identifiers in
   * the current scope will be removed from the SymbolTable.
   * @requires old.currentLevel() > -1;
   * @ensures  this.currentLevel() == old.currentLevel()-1;
   */
  public void closeScope() {
    // TODO: Remove all identifiers from current scope ...
    this.currentLevel -= 1;
  }

  /** Returns the current scope level. */
  public int currentLevel() {
    return this.currentLevel;
  }

  /**
   * Enters an id together with an entry into this SymbolTable
   * using the current scope level. The entry's level is set to
   * currentLevel().
   * @requires id != null && id.length() > 0 && entry != null;
   * @ensures  this.retrieve(id).getLevel() == currentLevel();
   * @throws SymbolTableException when there is no valid
   *    current scope level, or when the id is already declared
   *    on the current level.
   */
  public void enter(String id, Entry entry) throws SymbolTableException {
    if (this.currentLevel() < 0) {
      throw new SymbolTableException("Invalid current scope level.");
    }

    if (this.table.containsKey(id)) {
      List<Entry> entries = this.table.get(id);
      Entry lastEntry = entries.get(entries.size() - 1);

      if (lastEntry.getLevel() == this.currentLevel()) {
        throw new SymbolTableException("Id already declared on current level.");
      }
    }

    if (!table.containsKey(id)) {
      this.table.put(id, new ArrayList<Entry>());
    }

    entry.setLevel(this.currentLevel());
    this.table.get(id).add(entry);
  }

  /**
   * Get the Entry corresponding with id whose level is
   * the highest; in other words, that is defined last.
   * @return  Entry of this id on the highest level
   *          null if this SymbolTable does not contain id
   */
  public Entry retrieve(String id) {
    if (this.table.containsKey(id)) {
      // Not sure if this always works
      List<Entry> entries = this.table.get(id);
      return entries.get(entries.size() - 1);
    }

    return null;
  }
}

/** Exception class to signal problems with the SymbolTable */
class SymbolTableException extends Exception {
  /** {@link serialVersionUID} is required for Serializable */
  public static final long serialVersionUID = 24362462L;
  public SymbolTableException(String msg) { super(msg); }
}
