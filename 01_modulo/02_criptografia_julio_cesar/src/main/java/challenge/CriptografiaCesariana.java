package challenge;

public class CriptografiaCesariana implements Criptografia {
	
	/* Criptografa um texto */
    @Override
    public String criptografar(String texto) {
        if (texto.equals("")) {
            throw new IllegalArgumentException("Envie um texto válido!");
        }
        String[] palavras = texto.toLowerCase().split(" ");
        String fraseCripto = "";
        for (String palavra : palavras){
            String palavraCripto = "";
            for (int index = 0; index < palavra.length(); index++){
                if ((palavra.charAt(index) > 47) && (palavra.charAt(index) < 58)) {
                    palavraCripto = palavraCripto + ((char) palavra.charAt(index));
                } else {
                    int codigoLetra = ((int) palavra.charAt(index)) + 3;
                    if (codigoLetra > 126) {
                        codigoLetra -= 94;
                    }
                    palavraCripto = palavraCripto + ((char) codigoLetra);
                }
            }
            fraseCripto = fraseCripto + " " + palavraCripto;
        }
        return fraseCripto.toLowerCase().trim();
    }

    /* Descriptografa um texto */
    @Override
    public String descriptografar(String texto) {
        if (texto.equals("")) {
            throw new IllegalArgumentException("Envie um texto válido!");
        }
        String[] palavras = texto.toLowerCase().split(" ");
        String fraseCripto = "";
        for (String palavra : palavras){
            String palavraCripto = "";
            for (int index = 0; index < palavra.length(); index++){
                if ((palavra.charAt(index) > 47) && (palavra.charAt(index) < 58)) {
                    palavraCripto = palavraCripto + ((char) palavra.charAt(index));
                } else {
                    int codigoLetra = ((int) palavra.charAt(index)) - 3;
                    if (codigoLetra < 32) {
                        codigoLetra += 94;
                    }
                    palavraCripto = palavraCripto + ((char) codigoLetra);
                }
            }
            fraseCripto = fraseCripto + palavraCripto + " ";
        }
        return fraseCripto.toLowerCase().trim();
    }
}
