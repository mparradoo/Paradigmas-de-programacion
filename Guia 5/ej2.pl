Estos son hechos. Le dicen a Prolog qué palabras hay y a qué categoría pertenecen.

palabra(determinante,el). --> "el" es un determinante
palabra(determinante,un).
palabra(nucleo,pez).
palabra(nucleo,'alfajor triple').
palabra(verbo,come).
palabra(verbo,compra).


Esta es una regla que define cuándo una secuencia de cinco palabras forma una oración válida.

oracion(Palabra1,Palabra2,Palabra3,Palabra4,Palabra5):-
   palabra(determinante,Palabra1),
   palabra(nucleo,Palabra2),
   palabra(verbo,Palabra3),
   palabra(determinante,Palabra4),
   palabra(nucleo,Palabra5).


-P1 será el primer determinante
-P2 será el primer núcleo
-P3 será el verbo
-P4 será el segundo determinante
-P5 será el segundo núcleo

La regla dice:

Una oración (oracion(P1, P2, P3, P4, P5)) existe si:

P1 es un determinante,
P2 es un núcleo,
P3 es un verbo,
P4 es un determinante,
P5 es un núcleo.

¿Qué consulta hay que hacer para averiguar todas las oraciones posibles? Listar los resultados que generará Prolog en el orden esperado.

?- oracion(P1, P2, P3, P4, P5).
Prolog busca todas las combinaciones posibles de palabras que cumplan esa estructura, probando cada combinación válida entre los hechos que tiene en su base de conocimiento.

→ Prolog elige primero todos los valores posibles para P1 (determinante),
luego todos para P2 (nucleo),
luego P3 (verbo),
y así sucesivamente.

el pez come el pez
el pez come el alfajor triple
el pez come un pez
el pez come un alfajor triple
el pez compra el pez
el pez compra el alfajor triple
...
