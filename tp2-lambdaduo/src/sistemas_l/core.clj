(ns sistemas-l.core
  (:require [sistemas-l.parser :refer [parsear-archivo]]
            [sistemas-l.procesamiento :refer [procesar-sistema-l]]
            [sistemas-l.tortuga :refer [ejecutar-comandos]]
            [sistemas-l.svg :refer [generar-svg]])
  (:gen-class))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; FUNCIÓN PRINCIPAL
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn -main
  "Función principal del programa"
  [& args]
  (assert (= (count args) 3) "Uso: lein run <archivo-sistema-l> <iteraciones> <archivo-salida>")
  (let [[archivo-entrada iteraciones-str archivo-salida] args
        iteraciones (Integer/parseInt iteraciones-str)]

    ;; Leer y parsear el archivo
    (let [sistema-l (parsear-archivo archivo-entrada)]

      ;; Procesar el sistema-L
      (let [cadena-final (procesar-sistema-l sistema-l iteraciones)]

        ;; Generar las líneas con la tortuga
        (let [lineas (ejecutar-comandos cadena-final (:angulo sistema-l))]

          ;; Generar y escribir el SVG
          (let [contenido-svg (generar-svg lineas)]
            (spit archivo-salida contenido-svg)))))))