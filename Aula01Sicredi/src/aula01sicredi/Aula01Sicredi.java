package aula01sicredi;

/**
 *
 * @author cadu
 */
public class Aula01Sicredi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] vet = new int[20];
        
        for (int i=0; i<20; i++) {
            vet[i] = (i+1)*10;
        }
        System.out.println("Vetor 1: ");
        for (int i=0; i<20; i++) {
            System.out.println("vet[" + i + "]= " + vet[i]);
        }

        System.out.println("-----------------------------------------");
        System.out.println("Vetor 1 invertido: ");
        int j=19;
        for (int i=0; i<10; i++) {
            int aux = vet[i];
            vet[i] = vet[j];
            vet[j] = aux;
            j--;
        }

        for (int i=0; i<20; i++) {
            System.out.println("vet[" + i + "]= " + vet[i]);
        }

        System.out.println("-----------------------------------------");

        int num = 20;
        vet[10] = num;
        System.out.println("Ocorrencias de "+ num + ": " + nOcorrencias(vet, num));
        System.out.println("-----------------------------------------");
        System.out.println("Existem numeros repetidos? " + hasRepeat(vet));
        System.out.println("-----------------------------------------");
        System.out.println("Qtde de numeros repetidos: " + nroRepeat(vet));
        System.out.println("-----------------------------------------");
        System.out.println("Lista de numeros repetidos: ");
        int[] vetor = listRepeat(vet);
        for (int i=0; i<vetor.length; i++) {
            System.out.println("vet[" + i + "]= " + vetor[i]);
        }
        System.out.println("-----------------------------------------");

        int[] vet2 = new int[20];
        for (int i=0; i<20; i++) {
            vet2[i] = (i+15)*10;
        }
        System.out.println("Lista 1: ");
        for (int i=0; i<20; i++) {
            System.out.println("vet[" + i + "]= " + vet[i]);
        }
        System.out.println("-----------------------------------------");
        System.out.println("Lista 2: ");
        for (int i=0; i<20; i++) {
            System.out.println("vet2[" + i + "]= " + vet2[i]);
        }
        System.out.println("-----------------------------------------");
        System.out.println("Uniao de 2 listas: ");
        vetor = union(vet, vet2);
        for (int i=0; i<vetor.length; i++) {
            System.out.println("vet[" + i + "]= " + vetor[i]);
        }
        System.out.println("-----------------------------------------");

        System.out.println("Intercecçao de 2 listas: ");
        vetor = intersectMaster(vet, vet2);
        for (int i=0; i<vetor.length; i++) {

            System.out.println("vet[" + i + "]= " + vetor[i]);
        }
        System.out.println("-----------------------------------------");

        System.out.println("Diferença de 2 listas: ");
        vetor = differenceMaster(vet, vet2);
        for (int i=0; i<vetor.length; i++) {
            System.out.println("vet[" + i + "]= " + vetor[i]);
        }

    }

    public static int nOcorrencias(int[] vetor, Integer el) {
        int ocorrencias = 0;
        for (int i=0; i<vetor.length; i++) {
            if (vetor[i] == el) {
                ocorrencias++;
            }
        }
        return ocorrencias;
    }

    public static boolean hasRepeat(int[] vetor) {
        for (int i=0; i<vetor.length; i++) {
            for (int j=i+1; j<vetor.length; j++) {
                if (vetor[i] == vetor[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int nroRepeat(int[] l) {
        int nro=0;
        for (int i=0; i<l.length; i++) {
            for (int j=i+1; j<l.length; j++) {
                if (l[i] == l[j]) {
                    nro++;
                }
            }
        }
        return nro;
    }

    public static int[] listRepeat(int[] l) {
        int tamanho = nroRepeat(l);
        int[] list = new int[tamanho];
        int k=0;
        for (int i=0; i<l.length; i++) {
            for (int j=i+1; j<l.length; j++) {
                if (l[i] == l[j]) {
                    list[k] = l[i];
                    k++;
                }
            }
        }
        return list;
    }

    public static int[] union(int[] l1, int[] l2) {
        int tamanho = l1.length + l2.length;
        int[] list = new int[tamanho];
        int j=0;
        for (int i=0; i<l1.length; i++) {
            list[j] = l1[i];
            j++;
        }
        for (int i=0; i<l2.length; i++) {
            list[j] = l2[i];
            j++;
        }
        return list;
    }

    public static int[] intersect(int[] l1, int[] l2) {
        int tamanho = l1.length + l2.length;
        int[] list = new int[tamanho];
        int k=0;
        for (int i=0; i<l1.length; i++) {
            for (int j=0; j<l2.length; j++) {
                if (l1[i] == l2[j]) {
                    list[k] = l1[i];
                    k++;
                }
            }
        }
        return list;
    }

    public static int[] difference(int[] l1, int[] l2) {
        int tamanho = l1.length + l2.length;
        int[] list = new int[tamanho];
        int k=0, cont=0;
        for (int i=0; i<l1.length; i++) {
            cont=0;
            for (int j=0; j<l2.length; j++) {
                if (l1[i] == l2[j]) {
                    cont++;
                }
            }
            if (cont==0) {
                list[k] = l1[i];
                System.out.println("Esse numero: "+ l1[i]);
                k++;
            }
        }
        return list;
    }

    public static int[] intersectMaster(int[] l1, int[] l2) {
        int tam = 0;
        for (int i=0; i<l1.length; i++) {
            for (int j=0; j<l2.length; j++) {
                if (l1[i] == l2[j]) {
                    tam++;
                }
            }
        }

        int[] list = new int[tam];
        int k=0;
        for (int i=0; i<l1.length; i++) {
            for (int j=0; j<l2.length; j++) {
                if (l1[i] == l2[j]) {
                    list[k] = l1[i];
                    k++;
                }
            }
        }
        return list;
    }

    public static int[] differenceMaster(int[] l1, int[] l2) {
        int tamanho = 0;
        int cont=0;
        for (int i=0; i<l1.length; i++) {
            cont=0;
            for (int j=0; j<l2.length; j++) {
                if (l1[i] == l2[j]) {
                    cont++;
                }
            }
            if (cont==0) {
                tamanho++;
            }
        }

        int[] list = new int[tamanho];
        int k=0;
        for (int i=0; i<l1.length; i++) {
            cont=0;
            for (int j=0; j<l2.length; j++) {
                if (l1[i] == l2[j]) {
                    cont++;
                }
            }
            if (cont==0) {
                list[k] = l1[i];
                k++;
            }
        }
        return list;
    }

}
