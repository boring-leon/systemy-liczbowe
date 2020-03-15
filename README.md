# dec -> bin

1. Znajduję największy wykładnik dwójki, jaki zostanie użyty do sumowania.
W tym celu obliczam logarytm przy podstawie 2 z podanej liczby. Korzystam ze wzoru na zamianę podstaw logarytmów, ponieważ biblioteka
Math pozwala jedynie na obliczenie logarytmu o podstawie 10. 
```java
 public int getWeightExponent() {
    double exp = Math.log(this.decimalNumber) / Math.log(2);
    return (int) Math.floor(exp);
 }
```
Wynik zaokrąglam w dół do najbliższej liczby całkowitej.
2. Przechodzę kolejno przez wagi od największej w dół. Wybieram wagi, tak aby ich suma = danej liczbie dziesiętnej.
Jeżeli dana waga zostanie użyta, wpisuję '1' do StringBuildera. Jeżeli nie '0'.

# bin -> dec

1. Znajduje największy wykładnik dwójki użyty do zapisu liczby (długość łańcucha -1, bo zaczynamy od potęgi zerowej).
2. Za pomocą znalezionego wykładnika ustalam największą wagę. 
Analizuję  wagi od największej w dół - jeżeli w zapisie binarnym danej wadze odpowiada '1', to dodaję ją do sumy, jeżeli
'0', to pomijam.

# bin -> hex

1. Jeśli ilość znaków nie jest podzielna przez 4, dopisuję odpowiednią ilość zer na początku łańcucha.
```java
private int getNewBinaryStringLength() {
   int binaryStringLength = binaryString.length();
    return binaryStringLength % 4 == 0 ? binaryStringLength : (int) (4 * Math.ceil((double) binaryStringLength / 4));
}

private StringBuilder getNewBinaryStringBuilder() {
    StringBuilder builder = new StringBuilder(this.binaryString);

    for (int i = 0; i < this.getNewBinaryStringLength() - binaryString.length(); i++) {
        builder.insert(i, "0");
    }

    return builder;
}
```
Rozbijam łańcuch z liczbą w postaci binarnej na sekwencje po 4 znaki
Liczbom w sekwencji odpowiadają kolejne potęgi dwójki (1, 2, 4, 8).
2. Każdemu znakowi w sekwencji przypisuję wagę, czyli kolejną potęgę dwójki. Warto zauważyć, że zależność pomiędzy indeksem
znaku w sekwencji a wykładnikiem potęgi to ``` -n + 3 ```, przyjmując za pierwszy indeks o wartości 0.
3. Sumuję wagi, które odpowiadają znakowi '1' w sekwencji.
4. Sumę wag każdej sekwencji zamieniam znak po znaku na hex. Maksymalna możliwa wartość sumy to 15.
Zostawiam liczby od 0 do 9, od 10 do 15 zamieniam na kolejne litery alfabetu (A,B,C,D,E,F).

# hex -> bin

1. Zamieniam każdy znak w pętli na liczbę dziesiętną. 
2. Zamieniam liczby dziesiętne na dwójkowe.
3. Zwracam "sklejony" wynik.
