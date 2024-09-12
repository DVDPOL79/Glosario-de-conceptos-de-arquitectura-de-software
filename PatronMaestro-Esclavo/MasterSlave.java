
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Interfaz de tarea de esclavo
interface Task extends Callable<Integer> {}

// Clase que representa un esclavo para procesar una parte de la lista
class SumTask implements Task {
    private List<Integer> numbers;
    
    public SumTask(List<Integer> numbers) {
        this.numbers = numbers;
    }
    
    @Override
    public Integer call() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}

// Clase que representa al maestro
class Master {
    private ExecutorService executorService;
    
    public Master(int numberOfSlaves) {
        this.executorService = Executors.newFixedThreadPool(numberOfSlaves);
    }
    
    public int processNumbers(List<Integer> numbers, int chunkSize) throws InterruptedException, ExecutionException {
        List<Future<Integer>> futures = new ArrayList<>();
        int numberOfTasks = (int) Math.ceil((double) numbers.size() / chunkSize);
        
        // Dividir el trabajo y enviar tareas a los esclavos
        for (int i = 0; i < numberOfTasks; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, numbers.size());
            List<Integer> chunk = numbers.subList(start, end);
            Task task = new SumTask(chunk);
            futures.add(executorService.submit(task));
        }
        
        // Recoger los resultados y calcular la suma total
        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get();
        }
        
        executorService.shutdown();
        return totalSum;
    }
}

// Clase principal para ejecutar el ejemplo
public class MasterSlave {
    public static void main(String[] args) {
        try {
            Master master = new Master(4); // Crear un maestro con 4 esclavos
             List<Integer> numbers = List.of(12, 8, 73, 64, 2, 23, 57, 104, 11, 99);
             int chunkSize = 3;
             int result = master.processNumbers(numbers, chunkSize);
              System.out.println("El resulatado de la suma es: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
