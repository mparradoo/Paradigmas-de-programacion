(ns superproyecto.Ej2)
;Definir la función capicua? que reciba un número entero no negativo de hasta 5 dígitos y devuelva true si el número es capicúa; si no, false.
; el "?" es cuando devuelve un booleano

(defn palindrome? [s]
      (case (count s)
            (0 1) true
            (let [f (first s)
                  m (rest (butlast s))
                  l (last s)]
                 (and (= f l)
                      (palindrome? m)))))

(defn capicua? [n]
      (palindrome? (seq (str n))))

(assert (capicua? 5))
(assert (capicua? 55))
(assert (capicua? 585))
(assert (capicua? 59895))
(assert (not (capicua? 59875)))