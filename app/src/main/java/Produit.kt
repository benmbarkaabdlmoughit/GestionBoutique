
abstract class Produit(
    var code : String,
    var nom: String,
    var prixHt: Double,
    stock: Int
) {
    var stock : Int = stock
        private set
    abstract fun calculerTTC(): Double

     fun retirerStock(quentite : Int) : Boolean{
        if(stock >= quentite ){
            stock -= quentite
            return true
        }
        else return false
    }

    fun ajouterStock(quentite: Int){
        stock += quentite

    }
}