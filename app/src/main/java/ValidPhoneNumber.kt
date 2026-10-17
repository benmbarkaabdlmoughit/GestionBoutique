 fun String.isValidPhoneNumber(): Boolean {
    if(this.length != 12){
        return false
    }
    else if (this[0] != '+' || this[1] != '2'
        || this[2] != '1' || this[3] != '2'){
        return false
    }
     for(i in 4 until this.length){
         if (this[i] < '0' || this[i] > '9'){
             return false

         }
     }
     return true
}