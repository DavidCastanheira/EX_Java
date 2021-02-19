import java.util.Arrays;

public class Vetor<T> implements VetorInterface<T> {
  
  private T[] elementos;
  private int tamanho;

  public Vetor(int capacidade) {
    this.elementos = (T[]) new Object[capacidade];
    this.tamanho = 0;
  }
  
  @Override
  public void adicionar(T elemento) {
    aumentarCapacidade();    
    elementos[tamanho] = elemento;
    tamanho++;
  }

  @Override
  public void adicionar(int posicao, T elemento) {
    verificarPosicao(posicao);

    if(posicao > tamanho)
      throw new RuntimeException("");
    
    aumentarCapacidade();

    for(int i = tamanho-1; i >= posicao; i--)
      elementos[i+1] = elementos[i];
    
    elementos[posicao] = elemento;
    tamanho++;
  }

  @Override
  public void remover(int posicao) {
    verificarPosicao(posicao);

    if(posicao >= tamanho)
      throw new RuntimeException("");
    
    for(int i = posicao; i < tamanho-1; i++)
      elementos[i] = elementos[i+1];
    
    elementos[tamanho-1] = null;

    tamanho--;
  }

  @Override
  public T buscar(int posicao) {
    verificarPosicao(posicao);

    if(posicao >= tamanho)
      throw new RuntimeException("");

    return elementos[posicao];

  }

  @Override
  public int buscar(T elemento) {
    for(int i = 0; i < tamanho; i++)
      if(elementos[i].equals(elemento))
        return i;
    
    return -1;
  }

  @Override
  public int tamanho() {
    return tamanho;
  }

  private void aumentarCapacidade() {
    if(tamanho == elementos.length) {
      T[] elementosNovos = (T[]) new Object[elementos.length * 2];
      for(int i = 0; i < elementos.length; i++) {
        elementosNovos[i] = elementos[i];
      }
      elementos = elementosNovos;
    }
  }

  private void verificarPosicao(int posicao) {
    if(posicao < 0)
      throw new RuntimeException("PosiÃ§Ã£o InvÃ¡lida");
  }

  @Override
  public String toString() {
    return Arrays.toString(elementos);
  }

}
