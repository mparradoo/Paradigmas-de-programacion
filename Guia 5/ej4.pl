trenDirecto(saarbruecken,dudweiler).
trenDirecto(forbach,saarbruecken).
trenDirecto(freyming,forbach).
trenDirecto(stAvold,freyming).
trenDirecto(fahlquemont,stAvold).
trenDirecto(metz,fahlquemont).
trenDirecto(nancy,metz).

Escribir un predicado viajar/2 que permita averiguar si es posible o no viajar de una localidad a otra, ya sea en uno o más tramos de tren. Por ejemplo, viajar(nancy,saarbruecken) debe dar verdadero.


trenDirecto(saarbruecken,dudweiler).
trenDirecto(forbach,saarbruecken).
trenDirecto(freyming,forbach).
trenDirecto(stAvold,freyming).
trenDirecto(fahlquemont,stAvold).
trenDirecto(metz,fahlquemont).
trenDirecto(nancy,metz).


viajar(Origen, Destino):-
    trenDirecto(Origen, Destino). %Caso base


% Caso recursivo: si hay un tren directo de Origen a un Intermedio y luego podemos viajar desde Intermedio a Destino
viajar(Origen, Destino):-
    trenDirecto(Origen, Intermedio), % Hay tren de Origen a Intermedio
	viajar(Intermedio, Destino).    % Y se puede viajar desde Intermedio a Destino


%Escribir un predicado viajar/2 que permita averiguar si es posible o no viajar de una localidad a otra,
%ya sea en uno o más tramos de tren. Por ejemplo, viajar(nancy,saarbruecken) debe dar verdadero.