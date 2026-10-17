class Boutique(
    private val produits: MutableList<Produit> = mutableListOf()
) {
    fun indiceProdui(code : String): Int{
        for (i in produits.indices){
            if (produits[i].code == code){
                return i
            }
        }
        return -1
    }
    fun Ajouter(p : Produit): Boolean {
        for (i in produits.indices) {
            if (produits[i].code == p.code) {
                return true
            }
        }
        return false
    }

    fun supprimerCode(code : String) : Boolean{
        for (i in produits.indices){
            if (produits[i].code == code){
                produits.removeAt(i)
                return true
            }
        }
        return false
    }
    fun supprimerProdui(p : Produit): Boolean{
        for (i in produits.indices){
            if (produits[i].code == p.code){
                produits.removeAt(i)
                return true
            }
        }
        return false
    }
    fun nombreProduitsElectroniques() : Int{
        var total : Int = 0
        for(i in produits.indices) {
            if (produits[i] is ProduitElectonique) {
                total++

            }
        }
        return total

    }

}