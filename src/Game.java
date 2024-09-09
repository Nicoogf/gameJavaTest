import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinadas = false;

        // Arreglos
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        //
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
            System.out.print(letrasAdivinadas[i]);
        }

        while (!palabraAdivinadas && intentos < intentosMaximos) {
            System.out.println("Palabra a adivinar " + String.valueOf(letrasAdivinadas));
            System.out.println("Introduce una letra , por favor");
            char letra = Character.toLowerCase(scanner.next().charAt(0));
            boolean letraCorreta = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorreta = true;
                }
            }

            if (!letraCorreta) {
                intentos++;
                System.out.println("Incorrecto, te quedan " + (intentosMaximos - intentos) + " intentos");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinadas = true;
                System.out.println("Adivinaste la Palabra " + palabraSecreta);
            }
        }

        if (!palabraAdivinadas) {
            System.out.println("Te quedaste sin intentos");
        }
        scanner.close();

    }
}
