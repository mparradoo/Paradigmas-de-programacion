(ns sistemas-l.tortuga)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; ESTADO DE LA TORTUGA
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn crear-tortuga
  "Crea una nueva tortuga en la posición inicial"
  []
  {:x 0.0
   :y 0.0
   :angulo 90.0  ; 90 grados = mirando hacia arriba
   :pluma-abajo true})

(defn copiar-tortuga
  "Crea una copia de la tortuga con el mismo estado"
  [tortuga]
  (merge {} tortuga))

(defn avanzar-tortuga
  "Mueve la tortuga n unidades en la dirección actual"
  [tortuga distancia]
  (let [angulo-rad (Math/toRadians (:angulo tortuga))
        dx (* distancia (Math/cos angulo-rad))
        dy (* distancia (Math/sin angulo-rad))]
    (-> tortuga
        (update :x + dx)
        (update :y + dy))))

(defn girar-tortuga
  "Gira la tortuga el ángulo especificado (positivo = derecha, negativo = izquierda)"
  [tortuga angulo]
  (update tortuga :angulo + angulo))

(defn pluma-arriba
  "Levanta la pluma de la tortuga"
  [tortuga]
  (assoc tortuga :pluma-abajo false))

(defn pluma-abajo
  "Baja la pluma de la tortuga"
  [tortuga]
  (assoc tortuga :pluma-abajo true))

;; ===== INTERPRETACIÓN DE COMANDOS =====

(defn interpretar-caracter
  "Interpreta un caracter y devuelve el nuevo estado (pila y líneas)"
  [estado caracter angulo-sistema]
  (let [{:keys [pila lineas]} estado
        tortuga-actual (peek pila)
        x-inicial (:x tortuga-actual)
        y-inicial (:y tortuga-actual)]

    (case caracter
      ;; Avanzar dibujando
      (\F \G) (let [nueva-tortuga (avanzar-tortuga tortuga-actual 1)]
                (if (:pluma-abajo tortuga-actual)
                  {:pila (conj (pop pila) nueva-tortuga)
                   :lineas (conj lineas {:x1 x-inicial
                                         :y1 y-inicial
                                         :x2 (:x nueva-tortuga)
                                         :y2 (:y nueva-tortuga)})}
                  {:pila (conj (pop pila) nueva-tortuga)
                   :lineas lineas}))

      ;; Avanzar sin dibujar
      (\f \g) (let [tortuga-sin-pluma (pluma-arriba tortuga-actual)
                    tortuga-avanzada (avanzar-tortuga tortuga-sin-pluma 1)
                    tortuga-final (pluma-abajo tortuga-avanzada)]
                {:pila (conj (pop pila) tortuga-final)
                 :lineas lineas})

      ;; Girar a la derecha
      \+ {:pila (conj (pop pila) (girar-tortuga tortuga-actual angulo-sistema))
          :lineas lineas}

      ;; Girar a la izquierda
      \- {:pila (conj (pop pila) (girar-tortuga tortuga-actual (- angulo-sistema)))
          :lineas lineas}

      ;; Invertir dirección
      \| {:pila (conj (pop pila) (girar-tortuga tortuga-actual 180))
          :lineas lineas}

      ;; Apilar tortuga
      \[ {:pila (conj pila (copiar-tortuga tortuga-actual))
          :lineas lineas}

      ;; Desapilar tortuga
      \] {:pila (pop pila)
          :lineas lineas}

      ;; Ignorar cualquier otro caracter
      estado)))

(defn ejecutar-comandos
  "Ejecuta todos los comandos de la cadena y devuelve las líneas dibujadas"
  [cadena angulo-sistema]
  (let [estado-inicial {:pila [(crear-tortuga)]
                        :lineas []}]
    (:lineas
      (reduce (fn [estado caracter]
                (interpretar-caracter estado caracter angulo-sistema))
              estado-inicial
              cadena))))
