package aps;
import java.util.Arrays;
import java.util.Random;

public class Aps {
    
    static int countBubble = 0, countSelection = 0, countInsert = 0, countHeap = 0, countMerge = 0, countQuick = 0, countCount = 0, countBucket = 0, countRadix = 0;
    static long timeBubble = 0,  timeSelection = 0, timeInsert = 0, timeHeap = 0, timeMerge = 0, timeQuick = 0, timeCount = 0, timeBucket = 0, timeRadix = 0;
      
    public static void main(String[] args) {
        // Numero do Vetor
        int numVetor = 50;
        // Tamanho do Vetor
        int tamVetor = 50;
        // Cria e executa todos os vetores e as funções
        for (int i = 0; i < numVetor; i++) {
            // Cria vetor com numeros randomicos
            int vet[] = new int[tamVetor];
            Random r = new Random();
            for (int j = 0; j < tamVetor; j++) {
                vet[j] = r.nextInt(tamVetor);
            }
            // Replica o Array e cria o vetOg
            int [] vetOg = Arrays.copyOf(vet, vet.length);
            // Executa os Algoritmos   
            bubbleSort(vet);
            vet = Arrays.copyOf(vetOg, vetOg.length);
            
            selectionSort(vet);
            vet = Arrays.copyOf(vetOg, vetOg.length);
            
            insertSort(vet);
            vet = Arrays.copyOf(vetOg, vetOg.length);
            
            heapSort(vet);
            vet = Arrays.copyOf(vetOg, vetOg.length);

            mergeSort(vet,vet.length);
            vet = Arrays.copyOf(vetOg, vetOg.length);
            
            quickSort(vet, 0, tamVetor - 1);            
            vet = Arrays.copyOf(vetOg, vetOg.length);
            
            countSort(vet);
            vet = Arrays.copyOf(vetOg, vetOg.length);
            
            sort(vet,pegaMaior(vet)); 
            vet = Arrays.copyOf(vetOg, vetOg.length);
            
            radixSort(vet,pegaMaior(vet)); 
            vet = Arrays.copyOf(vetOg, vetOg.length);
        }
     
       
        // Exibe os resultados
        System.out.println("BubbleSort");
        media(countBubble,numVetor);
        System.out.println("Tempo de Execução: "+timeBubble+" mcs \n");
        
        System.out.println("SelectionSort");
        media(countSelection,numVetor);
        System.out.println("Tempo de Execução: "+timeSelection+" mcs \n");
        
        System.out.println("InsertSort");
        media(countInsert,numVetor);
        System.out.println("Tempo de Execução: "+timeInsert+" mcs \n");
        
        System.out.println("HeapSort");
        media(countHeap,numVetor);
        System.out.println("Tempo de Execução: "+timeHeap+" mcs \n");
        
        System.out.println("MergeSort");
        media(countMerge,numVetor);
        System.out.println("Tempo de Execução: "+timeMerge+" mcs \n");
        
        System.out.println("QuickSort");
        media(countQuick,numVetor);
        System.out.println("Tempo de Execução: "+timeQuick+" mcs \n");
        
        System.out.println("CountSort");
        media(countCount,numVetor);
        System.out.println("Tempo de Execução: "+timeCount+" mcs \n");
        
        System.out.println("BucketSort");
        media(countBucket,numVetor);
        System.out.println("Tempo de Execução: "+timeBucket+" mcs \n");
        
        System.out.println("RadixtSort");
        media(countRadix,numVetor);
        System.out.println("Tempo de Execução: "+timeRadix+" mcs \n");
         
    }
    
        
    public static void insertion(int[] vetor){
        for (int i = 1; i < vetor.length; i++){
            int aux = vetor[i];
            int j = i;
            while ((j > 0) && (vetor[j-1] > aux)){
                    vetor[j] = vetor[j-1];
                    j -= 1;
            }
            vetor[j] = aux;
        }
    }
    
    // BubbleSort
    public static void bubbleSort( int vet[] ){
        long tempInicial = System.nanoTime();
        int temp;
        int n = vet.length;
        boolean troca;
        for (int i = n-1; i > 0; i--) {
            troca = false;
            for (int j = 0; j < i; j++) {
                
                if (vet[j+1] < vet[j] ) {
                    temp = vet[j];
                    vet[j] = vet[j+1];
                    vet[j+1] = temp;
                    troca = true;
                  countBubble++;
                }
            }
        }
        long tempFinal = System.nanoTime();
        timeBubble =+ (tempFinal - tempInicial) / 1000;     
    }
    
    // Selection Sort
    public static void selectionSort(int vet[]){
        long tempInicial = System.nanoTime();
        int temp;
        int imenor, i, j;
        int n = vet.length;
        for(i=0; i < n - 1; i++ ){
            imenor = i;
            for(j=i+1; j<n; j++){
                countSelection++;
                if(vet[j] < vet[imenor]){
                    imenor = j;  
                }
                temp = vet[i];
                vet[i] = vet[imenor];
                vet[imenor] = temp;
            }
        }
        long tempFinal = System.nanoTime();
        timeSelection =+ (tempFinal - tempInicial) / 1000;
    }

    // Insert Sort
    static void insertSort( int vet[] ){
        long tempInicial = System.nanoTime();
        int i, j;
        int n = vet.length;
        for ( i = 1; i < n; i++) {
            //countInsert++;
            int aux = vet[i];
            j = i-1;
            while( (j >= 0) && (vet[j]) > aux ){
                countInsert++;
                vet[j+1] = vet[j];
                j--;
            } 
            vet[j+1] = aux;
        }  
        long tempFinal = System.nanoTime();
        timeInsert =+ (tempFinal - tempInicial) / 1000;
    }
    
    // Heap Sort
    public static void heapSort(int vet[]){ 
        long tempInicial = System.nanoTime();
        int n = vet.length; 
      
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(vet, n, i); 
            countHeap++;
        }

        for (int i=n-1; i>=0; i--){ 
            int temp = vet[0]; 
            vet[0] = vet[i]; 
            vet[i] = temp; 
  
            heapify(vet, i, 0); 
            countHeap++;
        } 
        long tempFinal = System.nanoTime();
        timeHeap=+ (tempFinal - tempInicial) / 1000;
    } 
    
    public static void heapify(int arr[], int n, int i) { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        countHeap++;
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 

        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        countHeap++;
        if (largest != i){ 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            heapify(arr, n, largest); 
        } 
    } 
    
    // Merge Sort
    public static void mergeSort(int[] a, int n) {
        long tempInicial = System.nanoTime();
        if (n < 2) { return; }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
            countMerge++;
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
            countMerge++;
        }
        
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        
        merge(a, l, r, mid, n - mid);
        
        long tempFinal = System.nanoTime();
        timeMerge =+ (tempFinal - tempInicial) / 1000;
    }
   
    public static void merge( int[] a, int[] l, int[] r, int left, int right) {
        long tempInicial = System.nanoTime();
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] < r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
            countMerge++;
        }
        while (i < left) {
            a[k++] = l[i++];
            countMerge++;
        }
        while (j < right) {
            a[k++] = r[j++];
            countMerge++;
        }
        long tempFinal = System.nanoTime();
        timeMerge =+ (tempFinal - tempInicial) / 1000;
    }
    
    // QuikSort
    public static void quickSort(int v[], int esquerda, int direita) {
        long tempInicial = System.nanoTime();
        int esq = esquerda;
        int dir = direita;
        int pivo = v[(esq + dir) / 2];
        int troca;
        while (esq <= dir) {
            while (v[esq] < pivo) {
                countQuick++;
                esq = esq + 1;
            }
            while (v[dir] > pivo) {
                countQuick++;
                dir = dir - 1;
            }
            if (esq <= dir) {
                countQuick++;
                troca = v[esq];
                v[esq] = v[dir];
                v[dir] = troca;
                esq = esq + 1;
                dir = dir - 1;
            }
            countQuick++;
        }
        if (dir > esquerda){
            countQuick++;
            quickSort(v, esquerda, dir);
        }     
        if (esq < direita){
            countQuick++;
            quickSort(v, esq, direita);
        }
        long tempFinal = System.nanoTime();
        timeQuick =+ (tempFinal - tempInicial) / 1000;
    }
            
    // CountSort
    public static void countSort(int vet[]){ 
        long tempInicial = System.nanoTime();
        int n = vet.length; 
  
        int output[] = new int[n]; 
        int count[] = new int[256]; 
        
        //countCount++;
        for (int i=0; i<256; ++i) 
            count[i] = 0; 
         
        for (int i=0; i<n; ++i){
            ++count[vet[i]]; 
            countCount++;
        }

        for (int i=1; i<=255; ++i){ 
            count[i] += count[i-1]; 
            //countCount++;
        }       
        
       
        for (int i = n-1; i>=0; i--){ 
            output[count[vet[i]]-1] = vet[i]; 
            --count[vet[i]]; 
           // countCount++;
        } 
        
        for (int i = 0; i<n; ++i) {
            vet[i] = output[i]; 
            countCount++;
        }
        
        long tempFinal = System.nanoTime();
        timeCount =+ (tempFinal - tempInicial) / 1000;
    } 
    
    
    //  BucketSort
    public static void bucketSort(int[] a, int maxVal) {
        long tempInicial = System.nanoTime();
        
        int [] bucket =  new int[maxVal+1];

        for (int i=0; i<bucket.length; i++) {
            bucket[i]=0;
            countBucket++;
        }
 
        for (int i=0; i<a.length; i++) {
            bucket[a[i]]++;
            countBucket++;
        }
 
        int outPos=0;
        for (int i=0; i<bucket.length; i++) {
            for (int j=0; j<bucket[i]; j++) {
                a[outPos++]=i;
                countBucket++;
            }
            countBucket++;
        }
        
        long tempFinal = System.nanoTime();
        timeBucket =+ (tempFinal - tempInicial) / 1000;
    }
    
    public static void sort(int[] a, int maxVal) {
        long tempInicial = System.nanoTime();
        
        int [] bucket = new int[maxVal+1];
        for (int i=0; i<bucket.length; i++) {
            bucket[i]=0;
            countBucket++;
        }
        for (int i=0; i<a.length; i++) {
            bucket[a[i]]++;
            countBucket++;
        }
        int outPos=0;
        for (int i=0; i<bucket.length; i++) {
            for (int j=0; j<bucket[i]; j++) {
                a[outPos++]=i;
                countBucket++;
            }
            countBucket++;
        }
        long tempFinal = System.nanoTime();
        timeBucket =+ (tempFinal - tempInicial) / 1000;
   }
 
    
    // Radix Sort
    static void radixSort(int arr[], int n){ 
        long tempInicial = System.nanoTime();
        int m = pegaMaior(arr); 
  
        for (int exp = 1; m/exp > 0; exp *= 10){
            countsortR(arr, n, exp); 
            countRadix++;
        }
        
        long tempFinal = System.nanoTime();
        timeRadix =+ (tempFinal - tempInicial) / 1000;
    } 
    
    static void countsortR(int arr[], int n, int exp) { 
        long tempInicial = System.nanoTime();
        int output[] = new int[n]; 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        for (i = 0; i < n; i++){
            count[ (arr[i]/exp)%10 ]++; 
            countRadix++;
        }
  
        for (i = 1; i < 10; i++){
            count[i] += count[i - 1]; 
            countRadix++;
        }
  
        for (i = n - 1; i >= 0; i--){ 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
            countRadix++;
        } 
  
        for (i = 0; i < n; i++){
            arr[i] = output[i]; 
            countRadix++;
        }
        long tempFinal = System.nanoTime();
        timeRadix =+ (tempFinal - tempInicial) / 1000;
    } 
  
     
    // Média
    public static void media(int numeros, int total){
        int valor = (numeros / total);
        System.out.println("Média de comparações: "+valor);
    }
    
    // Pega maior valor no Vetor
    static int pegaMaior(int[] sequence)   {
        int maxValue = 0;
        for (int i = 0; i < sequence.length; i++)
            if (sequence[i] > maxValue)
                maxValue = sequence[i];
        return maxValue;
    }
    
    // Imprime
    public static void imprime(int vet[]){
        System.out.println( Arrays.toString( vet ) );
    }

    
}
