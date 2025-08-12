% Caso base: el espejo de una hoja es la misma hoja
espejo(hoja(X), hoja(X)).


espejo(arbol(Izq,Der), arbol(Der_esp, Izq_esp)):-
    espejo(Izq, Izq_esp),
    espejo(Der, Der_esp).




