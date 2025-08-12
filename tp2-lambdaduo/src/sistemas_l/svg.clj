(ns sistemas-l.svg)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; GENERACIÓN DE SVG
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn calcular-limites
  "Calcula los límites del dibujo para determinar el viewBox"
  [lineas]
  (if (empty? lineas)
    {:x-min -10 :y-min -10 :x-max 10 :y-max 10}
    (let [todos-x (concat (map :x1 lineas) (map :x2 lineas))
          todos-y (concat (map :y1 lineas) (map :y2 lineas))]
      {:x-min (apply min todos-x)
       :y-min (apply min todos-y)
       :x-max (apply max todos-x)
       :y-max (apply max todos-y)})))

(defn generar-svg
  "Genera el contenido SVG a partir de las líneas"
  [lineas]
  (let [{:keys [x-min y-min x-max y-max]} (calcular-limites lineas)
        margen 10
        ancho (+ (- x-max x-min) (* 2 margen))
        alto (+ (- y-max y-min) (* 2 margen))
        viewbox (str (- x-min margen) " "
                     (- (- y-max) margen) " "
                     ancho " "
                     alto)]
    (str "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
         "<svg viewBox=\"" viewbox "\" xmlns=\"http://www.w3.org/2000/svg\">\n"
         (apply str
                (map (fn [linea]
                       (str "  <line x1=\"" (:x1 linea)
                            "\" y1=\"" (- (:y1 linea))
                            "\" x2=\"" (:x2 linea)
                            "\" y2=\"" (- (:y2 linea))
                            "\" stroke-width=\"1\" stroke=\"black\" />\n"))
                     lineas))
         "</svg>")))