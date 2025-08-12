(ns superproyecto.Ej1)


;Definir la función segundos que reciba los cuatro valores (días, horas, minutos y segundos) del tiempo que dura un evento y devuelva el valor de ese tiempo expresado solamente en segundos.



(defn segundos [d h m s]
      (+ segundos
         ( * d 24 60 60 )
         ( * h 60 60)
         ( * dias 60 60 24 )))
