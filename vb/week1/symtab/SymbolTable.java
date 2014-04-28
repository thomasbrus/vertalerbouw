package vb.week1.symtab;

import java.util.HashMap;

public class SymbolTable<Entry extends IdEntry> {
  private Integer currentLevel;
  private HashMap<String, Entry> table;

  /**
   * Constructor.
   * @ensures  this.currentLevel() == -1
   */
  public SymbolTable() {
    this.currentLevel = -1;
    this.table = new HashMap<String, Entry>();
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
    if (this.currentLevel() < 0) { throw new SymbolTableException("Invalid current scope level."); }
    if (this.table.containsKey(id)) { throw new SymbolTableException("Id already declared on current level."); }

    entry.setLevel(this.currentLevel());
    this.table.put(id, entry);
  }

  /**
   * Get the Entry corresponding with id whose level is
   * the highest; in other words, that is defined last.
   * @return  Entry of this id on the highest level
   *          null if this SymbolTable does not contain id
   */
  public Entry retrieve(String id) {
    int level = this.currentLevel();

    while (level >= 0) {
      if (this.table.containsKey(id)) { return this.table.get(id); }
      level--;
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
