(ns sistemas-l.parser
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; PARSEO DEL ARCHIVO
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn parsear-archivo
  "Lee un archivo de sistema-L y devuelve un mapa con el ángulo, axioma y reglas"
  [nombre-archivo]
  (with-open [reader (io/reader nombre-archivo)]
    (let [lineas (line-seq reader)
          angulo (Double/parseDouble (first lineas))
          axioma (second lineas)
          reglas-lineas (drop 2 lineas)
          reglas (into {}
                       (map (fn [linea]
                              (let [[pred suc] (str/split linea #" ")]
                                [(first pred) suc]))
                            reglas-lineas))]
      {:angulo angulo
       :axioma axioma
       :reglas reglas})))