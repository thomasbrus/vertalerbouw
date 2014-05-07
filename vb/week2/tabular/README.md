# How to run
============

## Lexer

```bash
$ java vb.week2.tabular.Lexer < vb/week2/tabular/sample-1.tex
Lexer ran succesfully (9 lines).
BSLASH	\
BEGIN	begin
LCURLY	{
...
```

## Parser

```bash
$ java vb.week2.tabular.Parser < vb/week2/tabular/sample-1.tex
Successfully parsed.
```

## HTML Emitter

```bash
$ java vb.week2.tabular.HTMLEmitter < vb/week2/tabular/sample-1.tex
<html>
<body>
	<table>
		<tr>
    ...
```
