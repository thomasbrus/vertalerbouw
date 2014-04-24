# Examples

```bash
$ cat vb/week1/symtab/sample-1.txt | java vb.week1.parser.Parser
true
```

```bash
$ cat vb/week1/symtab/sample-2.txt | java vb.week1.parser.Parser
true
```

```bash
$ echo "(D:hello U:world (D:x U:y) (D:o))" | java vb.week1.parser.Parser
true
```

```bash
$ echo "(D:hello_there! U:world (D:x U:y) (D:o))" | java vb.week1.parser.Parser
false
```
