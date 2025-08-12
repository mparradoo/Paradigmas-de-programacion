(ns superproyecto.Ej7)

;;Definir una función que devuelva true si una frase es un pangrama (es decir, si contiene todas las letras del alfabeto); si no, false. Por ejemplo:
;
;(pangrama? "Fabio me exige, sin tapujos, que añada cerveza al whisky") → true




(defn pangrama? [s]
      (let [alfabeto "abcdefghijklmnñopqrstuvwxyz"
            s (lower-case s)]
           (every? #(includes? s (str %)) alfabeto)))

(assert (pangrama? "Fabio me exige, sin tapujos, que añada cerveza al whisky"))
(assert (not (pangrama? "Esto no es un pangrama")))