public class SumaDeNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una lista de números separados por espacios: ");
        String input = scanner.nextLine();

        List<Integer> nums = new ArrayList<>();
        for (String s : input.split(" ")) {
            nums.add(Integer.parseInt(s));
        }

        System.out.println("La suma es: " + sumar(nums));
    }

    private static int sumar(List<Integer> nums) {
        // convertimos los Integer a `int` para hacer la suma más rápido.
        int[] arr = new int[nums.size()];
        // usamos el for clásico en lugar de `for (Integer n : nums)` porque es
        // más eficiente
        for(int i = 0; i < arr.length; i++) {
            arr[i] = nums.get(i).intValue();
        }

        // hacemos esta operación en un ciclo separado para favorecer la
        // localidad del cache del procesador:
        int suma = 0;
        for (int i = 0; i < arr.length; i++) {
            suma += nums.get(i);
        }
        return suma;
    }
}


//KOP --> intenta optimizar el codigo al mismo tiempo que codea

//En el ejemplo se viola el principio de optimización de Knuth (KOP), ya que en el método sumar() se aplican optimizaciones prematuras, sobre todo considerando que la lista de números no va a tener más que un puñado de elementos.

//El método se podría simplificar:

private static int sumar(List<Integer> nums) {
    int suma = 0;
    for (var n : nums) {
        sum += nums.get(i).intValue();
    }
    return sum;
}