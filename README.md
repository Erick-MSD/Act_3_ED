# Act_3_ED

Implementaciones en Java para:

- Serie de Fibonacci (recursiva y con memoización)
- Subset Sum (decisión y reconstrucción de una solución)
- Resolución de Sudoku por backtracking

## Estructura

```text
Act_3_ED/
	src/act3ed/
		Fibonacci.java
		SubsetSum.java
		SudokuSolver.java
		MainTests.java  <- ejecuta pruebas simples
```

## Cómo compilar y ejecutar (Windows PowerShell)

1. Compilar:

```powershell
mkdir out; javac -d out .\src\act3ed\*.java
```

2. Ejecutar pruebas:

```powershell
java -cp .\out act3ed.MainTests
```

No se requiere framework de pruebas externo.

Actividad 3 de Estructura de Datos
