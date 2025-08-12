palindromo([]).
palindromo([_]).



palindromo(Lista):-
    reverse(Lista, Lista).




%Escribir el predicado palindromo(Lista) que determine si la lista es palindrómica.
%Por ejemplo: palindromo([n,e,u,q,u,e,n]) debe dar verdadero.