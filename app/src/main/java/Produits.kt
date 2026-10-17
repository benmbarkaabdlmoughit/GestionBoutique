class ProduitElectonique(
     code : String,
     nom : String,
     prixHt: Double,
     stock: Int,
     var garantieMois : Int) : Produit(code , nom, prixHt, stock),Remisable {



    override fun appliquerRemise(poursentage: Double) {
        val remise = this.prixHt * poursentage / 100
        this.prixHt = this.prixHt - remise

    }

    override fun calculerTTC(): Double {
        return prixHt * (1 + 20.0 / 100)
    }
}
class ProduitAlimentaires(
     code : String,
     nom: String,
     prixHt: Double,
     stock: Int,
     var dateLimite : String) : Produit( code , nom, prixHt, stock){


    override fun calculerTTC(): Double {
        return prixHt * (1 + 10.0 / 100)
    }
}

