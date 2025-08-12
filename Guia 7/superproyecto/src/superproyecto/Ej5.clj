(ns superproyecto.Ej5)

;Definir la función qsort que recibe una secuencia y la ordena usando el algoritmo Quicksort.



(defn qsort [s]
      (if (empty? s)
        s
        (let [pivot (first s) ;; Elijo el primer elemento como pivote.
              r (rest s)] ;; El resto de los elementos.
             (concat  ;; Concatena tres cosas:
               (qsort (filter #(<= % pivot) r))             ;;Ordena los menores o iguales al pivote
               [pivot]                                      ;;Inserta el pivote.
               (qsort (filter #(> % pivot) r))))))          ;;Ordena los mayores al pivote.

(assert (= '(1 2 3 4 5 6) (qsort '(1 4 3 2 6 5))))