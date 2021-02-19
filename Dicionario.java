public class Dicionario<K,V> implements DicionarioInterface<K,V> {
  private Vetor<K> chaves;
  private Vetor<V> valores;

  public Dicionario() {
    chaves = new Vetor<>();
    valores = new Vetor<>();
  }

  //dic.add("A", 22);
  //dic.add("A", 85);
  
  public void add(K chave, V valor) {

    int chaveEncontrada = chaves.buscar(chave);

    if(chaveEncontrada == -1) {
      chaves.adicionar(chave);
      valores.adicionar(valor);
    } else {
      valores.adicionar(chaveEncontrada, valor);
    }
  }

  public V get(K chave) {
    int chaveEncontrada = chaves.buscar(chave);

    if(chaveEncontrada == -1)
      return null;

    return valores.buscar(chaveEncontrada);
  }

  public void remove(K chave) {
    int chaveEncontrada = chaves.buscar(chave);

    if(chaveEncontrada != -1) {
      chaves.remover(chaveEncontrada);
      valores.remover(chaveEncontrada);
    }
  }


}
