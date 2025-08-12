uruguayos_roja([rojo, _, _], [uruguayos, _, _]).
uruguayos_roja([_, rojo, _], [_, uruguayos, _]).
uruguayos_roja([_, _, rojo], [_, _, uruguayos]).

jaguar_espanioles([espanioles, _, _], [jaguar, _, _]).
jaguar_espanioles([_, espanioles, _], [_, jaguar, _]).
jaguar_espanioles([_, _, espanioles], [_, _, jaguar]).

%japo_derecha_caracol([caracol, _, _], [_, japoneses, _]).
%japo_derecha_caracol([_, caracol, _], [_, _, japoneses]).

japo_derecha_caracol([ListaMascotas, ListaNacionalidades]):-
    nth0(I1, ListaMascotas, caracol),
    nth0(I2, ListaNacionalidades, japoneses),
    I1 is I2 - 1.


%caracol_izquierda_azul([_, azul, _], [caracol, _, _]).
%caracol_izquierda_azul([_, _, azul], [_, caracol, _]).

caracol_izquierda_azul(ListaMascotas, Colores)-:
    nth0(I1, ListaMascotas, caracol),
    nth0(I2, Colores, azul),
    I1 is I2 + 1.





solucion(ListaColores, ListaNacionalidades, ListaMascotas):-
    permutation(ListaColores, [rojo, verde, azul]),
    permutation(ListaNacionalidades, [uruguayos, espanioles, japoneses]),
    permutation(ListaMascotas, [caracol, zebra, jaguar]),
    uruguayos_roja(ListaColores, ListaNacionalidades),
    jaguar_espanioles(ListaMascotas, ListaNacionalidades),
    japo_derecha_caracol(ListaMascotas, ListaNacionalidades),
    caracol_izquierda_azul(ListaMascotas, ListaColores).
