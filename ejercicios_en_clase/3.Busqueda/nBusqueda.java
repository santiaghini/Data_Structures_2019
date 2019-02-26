/**
 * nBusqueda
 */
public class nBusqueda {

    int valor;
    int resultadoSecuencial, resultadoMejorada, resultadoBinaria;
    long tiempoSecuencial, tiempoMejorada, tiempoBinaria;

    public nBusqueda(int valor) {
        this.valor = valor;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @return the resultadoMejorada
     */
    public int getResultadoMejorada() {
        return resultadoMejorada;
    }

    /**
     * @return the resultadoSecuencial
     */
    public int getResultadoSecuencial() {
        return resultadoSecuencial;
    }

    /**
     * @return the resultadoBinaria
     */
    public int getResultadoBinaria() {
        return resultadoBinaria;
    }

    /**
     * @return the tiempoMejorada
     */
    public long getTiempoMejorada() {
        return tiempoMejorada;
    }

    /**
     * @return the tiempoSecuencial
     */
    public long getTiempoSecuencial() {
        return tiempoSecuencial;
    }

    /**
     * @return the tiempoBinaria
     */
    public long getTiempoBinaria() {
        return tiempoBinaria;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @param resultadoMejorada the resultadoMejorada to set
     */
    public void setResultadoMejorada(int resultadoMejorada) {
        this.resultadoMejorada = resultadoMejorada;
    }

    /**
     * @param resultadoSecuencial the resultadoSecuencial to set
     */
    public void setResultadoSecuencial(int resultadoSecuencial) {
        this.resultadoSecuencial = resultadoSecuencial;
    }

    /**
     * @param tiempoMejorada the tiempoMejorada to set
     */
    public void setTiempoMejorada(long tiempoMejorada) {
        this.tiempoMejorada = tiempoMejorada;
    }

    /**
     * @param resultadoBinaria the resultadoBinaria to set
     */
    public void setResultadoBinaria(int resultadoBinaria) {
        this.resultadoBinaria = resultadoBinaria;
    }

    /**
     * @param tiempoSecuencial the tiempoSecuencial to set
     */
    public void setTiempoSecuencial(long tiempoSecuencial) {
        this.tiempoSecuencial = tiempoSecuencial;
    }

    /**
     * @param tiempoBinaria the tiempoBinaria to set
     */
    public void setTiempoBinaria(long tiempoBinaria) {
        this.tiempoBinaria = tiempoBinaria;
    }
}