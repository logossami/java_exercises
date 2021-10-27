import java.util.Random;

public class YTunnusGeneraattori {

	public static boolean tarkistaYTunnus(String yTunnus) {
		
		// POIMITAAN VIIMEINEN NUMERO Y-TUNNUKSESTA
		int yTunnuksenViimeinenNumero = yTunnus.length() - 1;
		char viimeinen = yTunnus.charAt(yTunnuksenViimeinenNumero);
		int viimeinenNumero = Integer.parseInt(viimeinen + "");
		// LASKETAAN VIIMEINEN NUMERO MUUSTA TIEDOSTA
		int[] kertoimet = {7,9,10,5,8,4,2};
		int summa = 0;
		for (int i = 0; i < 7; i++) {
			char merkki = yTunnus.charAt(i);
			int merkkiNumerona = Integer.parseInt(merkki + "");
			int kertolaskunTulos = kertoimet[i] * merkkiNumerona;
			summa = summa + kertolaskunTulos;
		}
		int jakojaannos = summa % 11;
		int tarkistusnumero = 0;
		if(jakojaannos == 0) {
			tarkistusnumero = 0;
		} else if(jakojaannos >= 2 && jakojaannos <= 10) {
			tarkistusnumero = 11 - jakojaannos;
		}
		// TARKISTETAAN, ONKO TARKISTENUMERO OIKEIN
		if(tarkistusnumero == viimeinenNumero) {
			return true;
		} else {
			return false;
		}
		
	}

	public String generoiYTunnus() {
		Random random = new Random();
		// LUODAAN STRING-MUUTTUJA, JOHON LAHDETAAN Y-TUNNUSTA TUOTTAMAAN
		String tunnuksenAlkuosa = "";
		

		for (int i = 0; i < 7; i++) {
			// LUO SATUNNAISLUVUN VÄLILTÄ 0-9
			int luku = random.nextInt(10);
			// KERRYTETÄÄN NÄITÄ ARVOJA STRINGIIN TUNNUKSENALKUOSA
			tunnuksenAlkuosa = tunnuksenAlkuosa + luku;
		}
		// LISÄTÄÄN Y-TUNNUKSESSA OLEVA VIIVA TÄSSÄ VÄLISSÄ
		tunnuksenAlkuosa = tunnuksenAlkuosa + "-";
		
		// TÄSTÄ ALKAA TARKISTUSNUMERON LASKENTA
		// NUMERO KERRYTYSMUUTTUJA, JOHON LASKETAAN KERTOIMIEN SUMMA
		int summa = 0;
		// TAULUKKO TARKISTUNUMERON LASKEMISEN KERTOIMISTA
		int[] kertoimet = {7,9,10,5,8,4,2};
		for (int i = 0; i < 7; i++) {
			// YHDEN MERKIN POIMINTA TIETYSTI INDEKSISTÄ STRINGISTÄ
			char merkki = tunnuksenAlkuosa.charAt(i);
			// MERKKI PITÄÄ MUUNTAA NUMEROKSI, JOTTA SILLÄ VOIDAAN LASKEA
			int merkkiNumerona = Integer.parseInt(merkki + "");
			// KERTOLASKUUN POIMITAAN KERROIN OIKEASTA SOLUSTA
			int kertolaskunTulos = kertoimet[i] * merkkiNumerona;
			// KERRYTETÄÄN SUMMAA
			summa = summa + kertolaskunTulos;
		}
		int jakojaannos = summa % 11;
		if(jakojaannos == 1) {
			while (jakojaannos == 1) {
				summa = 0;

				for (int i = 0; i < 7; i++) {
					// YHDEN MERKIN POIMINTA TIETYSTI INDEKSISTÄ STRINGISTÄ
					char merkki = tunnuksenAlkuosa.charAt(i);
					// MERKKI PITÄÄ MUUNTAA NUMEROKSI, JOTTA SILLÄ VOIDAAN LASKEA
					int merkkiNumerona = Integer.parseInt(merkki + "");
					// KERTOLASKUUN POIMITAAN KERROIN OIKEASTA SOLUSTA
					int kertolaskunTulos = kertoimet[i] * merkkiNumerona;
					// KERRYTETÄÄN SUMMAA
					summa = summa + kertolaskunTulos;
				}
				jakojaannos = summa % 11;
			}
			
		} 
		if(jakojaannos == 0) {
			tunnuksenAlkuosa = tunnuksenAlkuosa + "0";
		} else if(jakojaannos >= 2 && jakojaannos <=10) {
			int tarkistusnumero = 11 - jakojaannos;
			tunnuksenAlkuosa = tunnuksenAlkuosa + tarkistusnumero;
		}
		
		return tunnuksenAlkuosa;
	}

	public static void main(String[] args) {	
		// OK YTUNNUKSIA
		String yTunnus1 = "1572860-0";
		String yTunnus2 = "0737546-2";
		// EPÄPÄTEVIÄ Y-TUNNUKSIA
		String yTunnus3 = "1572860-1";
		String yTunnus4 = "0737544-9";

		if (tarkistaYTunnus(yTunnus1)) {
			System.out.println("Y-tunnus " + yTunnus1 + " on validi.");
		} else {
			System.out.println("Y-tunnus " + yTunnus1 + " ei ole validi.");
		}
		if (tarkistaYTunnus(yTunnus2)) {
			System.out.println("Y-tunnus " + yTunnus2 + " on validi.");
		} else {
			System.out.println("Y-tunnus " + yTunnus2 + " ei ole validi.");
		}
		if (tarkistaYTunnus(yTunnus3)) {
			System.out.println("Y-tunnus " + yTunnus3 + " on validi.");
		} else {
			System.out.println("Y-tunnus " + yTunnus3 + " ei ole validi.");
		}
		if (tarkistaYTunnus(yTunnus4)) {
			System.out.println("Y-tunnus " + yTunnus4 + " on validi.");
		} else {
			System.out.println("Y-tunnus " + yTunnus4 + " ei ole validi.");
		}

	}
}