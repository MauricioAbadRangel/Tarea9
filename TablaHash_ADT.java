public class TablaHash_ADT<T> {

    Arreglos_ADT<ArrayList> Tablash;
    int tamano;

    public TablaHash_ADT(int tamano) {
        this.tamano = tamano;
        if (tamano < 7) {
            this.tamano = 7;
            Tablash = new Arreglos_ADT(tamano);
        } else {
            double ayu = tamano % 2;
            if ((tamano % 2) == 0) { 
                this.tamano = tamano + 1;
                Tablash = new Arreglos_ADT(tamano);
            } else { 
                Tablash = new Arreglos_ADT(tamano);
            }

        }
        for (int F = 0; F < tamano; F++) { 
            Tablash.setItem(F, new ArrayList());
        }
    }

    public void agregar(int llave, T valor) {
        int posición = llave % tamano;
        Tablash.getItem(posición).add(valor);
    }

    public T valorDe(int llave) {
        int posición = llave % tamano;
        Object buscar;
        Object encontrado = null;

        if (Tablash.getItem(posición).size() == 1) {
            return (T) Tablash.getItem(posición).get(0);
        } else {
            buscar = JOptionPane.showInputDialog(null,
                    "Hay más de un elemento en ese lugar, ¿Qué estás buscando? ");
            for (int Q = 0; Q < Tablash.getItem(posición).size(); Q++) {
                if (Tablash.getItem(posición).get(Q).equals(buscar)) {
                    encontrado = Tablash.getItem(posición).get(Q);
                    System.out.println("En la posición " + Q);
                }
            }
        }
        return (T) encontrado;
    }

    public void eliminar(int llave) {
        int posición = llave % tamano;
        Object buscar;
        if (Tablash.getItem(posición).size() == 1) {
            Tablash.getItem(posición).remove(0);
        } else {
            buscar = JOptionPane.showInputDialog(null,
                    "Hay más de un elemento en ese lugar ");
            for (int Q = 0; Q < Tablash.getItem(posición).size(); Q++) {
                if (Tablash.getItem(posición).get(Q).equals(buscar)) {
                    Tablash.getItem(posición).remove(Q);
                }
            }
        }
    }

