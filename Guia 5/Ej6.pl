traduccion(eins,uno).
traduccion(zwei,dos).
traduccion(drei,tres).
traduccion(vier,cuatro).
traduccion(fuenf,cinco).
traduccion(sechs,seis).
traduccion(sieben,siete).
traduccion(acht,ocho).
traduccion(neun,nueve).

%Escribir el predicado traduccionLista(A,E)
%que produzca la traducción de una lista de números etre alemán y español. Por ejemplo,


% Caso base: la traducción de una lista vacía es una lista vacía
traduccionLista([],[]).



traduccionLista([Aleman|RestoAleman],[Español|RestoEspañol]):-
	traduccion(Aleman,Español),
    traduccionLista(RestoAleman, RestoEspañol).


