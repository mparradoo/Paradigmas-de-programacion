(ns sistemas-l.procesamiento)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; PROCESAMIENTO DEL SISTEMA-L
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn aplicar-reglas-una-vez
  "Aplica las reglas del sistema-L una vez a la cadena"
  [cadena reglas]
  (apply str
         (map (fn [caracter]
                (get reglas caracter (str caracter)))
              cadena)))

(defn procesar-sistema-l
  "Aplica las reglas del sistema-L n veces comenzando desde el axioma"
  [sistema-l iteraciones]
  (let [{:keys [axioma reglas]} sistema-l]
    (loop [cadena axioma
           n iteraciones]
      (if (zero? n)
        cadena
        (recur (aplicar-reglas-una-vez cadena reglas)
               (dec n))))))