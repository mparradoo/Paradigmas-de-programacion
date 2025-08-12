# TP2: Sistemas-L

## Integrantes

- Basile, Joaquín Ezequiel - Padrón: 111687
- Parrado, Mateo - Padrón: 111973

## Descripción del Trabajo

El proyecto implementa un generador de imágenes fractales utilizando sistemas-L, que es un tipo de formalismo de gramática que permite construir cadenas mediante reglas de producción. Además, se utiliza un sistema de gráficos tortuga para dibujar las imágenes generadas en el formato SVG.

## Implementación

La implementación se lleva a cabo en Clojure y se organiza en varias secciones principales:

1. **Parseo del Archivo:**
   - Se utiliza la función `parsear-archivo` para leer un archivo de entrada que contiene la descripción del sistema-L. Esta función extrae el ángulo de rotación, el axioma inicial y las reglas de transformación.

2. **Procesamiento del Sistema-L:**
   - La función `aplicar-reglas-una-vez` se encarga de aplicar las reglas a la cadena actual una vez.
   - La función `procesar-sistema-l` itera el número de veces especificado, utilizando el axioma y las reglas para generar la cadena final.

3. **Estado de la Tortuga:**
   - La tortuga (el cursor que dibuja) tiene un estado que incluye su posición (x, y), su ángulo de orientación y el estado de su pluma (levantada o bajada).
   - Las funciones `avanzar-tortuga`, `girar-tortuga`, `pluma-arriba`, y `pluma-abajo` manipulan este estado.

4. **Interpretación de Comandos:**
   - La función `interpretar-caracter` determina cómo un carácter de la cadena final afecta el estado de la tortuga.
   - `ejecutar-comandos` procesa toda la cadena generada por el sistema-L, interpretando cada comando y creando líneas que serán dibujadas.

5. **Generación de SVG:**
   - La función `calcular-limites` determina las dimensiones de la imagen SVG basándose en las coordenadas de las líneas generadas.
   - `generar-svg` crea un archivo SVG que representa visualmente la imagen generada por la tortuga.

## Ejecución

Para ejecutar el programa, se requiere tener instalado Leiningen. En la terminal, usar el siguiente comando:
`lein run <archivo-sistema-l> <iteraciones> <archivo-salida>`

## Formato de .sl

    <ángulo>
    <axioma>
    <predecesor1> <sucesor1>
    <predecesor2> <sucesor2>
    ...
