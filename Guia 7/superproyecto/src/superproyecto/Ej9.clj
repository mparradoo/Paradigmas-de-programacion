(ns superproyecto.Ej9)


;;Comenzando desde la esquina superior izquierda de una grilla de 2x2, y solo pudiendo moverse hacia la derecha (d) y abajo (a), hay exactamente 6 rutas a la esquina inferior derecha:
;
;
;
;Definir la función rutas que reciba las dimensiones de la grilla y devuelva una colección con todas las rutas posibles. Por ejemplo:



(ns main.clojure.ej9)

(defn rutas [d a]
      (if (= [d a] [0 0])
        '("")
        (let [rutas-d (if (pos? d) (rutas (dec d) a) nil)
              rutas-a (if (pos? a) (rutas d (dec a)) nil)]
             (concat (map #(str \d %) rutas-d) (map #(str \a %) rutas-a)))))

(assert (= #{"ddaa" "dada" "daad" "adda" "adad" "aadd"} (set (rutas 2 2))))