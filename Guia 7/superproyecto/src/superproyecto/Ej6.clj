(ns superproyecto.Ej6)

;;Definir la función slice que reciba una cadena s y un número n y devuelva una lista con todas las subcadenas contiguas de s cuyo tamaño sea n. Por ejemplo:


(defn slice [s n]
      (for [i (range (+ 1 (- (count s) n)))]
           (subs s i (+ i n))))

(assert (= '("abc" "bcd" "cde") (slice "abcde" 3)))
(assert (= '("ab" "bc" "cd" "de") (slice "abcde" 2)))

;;(count s): cantidad de caracteres en la cadena.
;
;(- (count s) n): cuántos lugares podés "moverte" para sacar una subcadena de tamaño n.
;
;(range (+ 1 ...)): incluye hasta el último índice posible para que subs no se pase del final.
;
;(subs s i (+ i n)): saca una subcadena de largo n desde el índice i.