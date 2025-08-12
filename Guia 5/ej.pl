mago(ron).
tieneVarita(harry).
juegaQuidditch(harry).
mago(X):- tieneEscoba(X), tieneVarita(X). --> X es un mago si X tiene una escoba y X tiene una varita"
tieneEscoba(X):- juegaQuidditch(X). --> X tiene una escoba si X juega al Quidditch".




:- se lee como "si" (es el "implicador" en lógica).
La coma , representa una conjunción lógica (es decir, "y").



mago(ron). --> true
bruja(ron). --> bruja no existe
mago(hermione). --> false
bruja(hermione). --> bruja no existe
mago(harry). --> true
mago(Y). --> ron y harry
bruja(Y). --> bruja no existe