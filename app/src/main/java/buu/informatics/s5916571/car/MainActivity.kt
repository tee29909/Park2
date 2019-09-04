package buu.informatics.s5916571.car

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TestLooperManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var parking = listOf<Car>(Car("Empty","Empty","Empty") ,
                 Car("Empty","Empty","Empty"),
                 Car("Empty","Empty","Empty"))
    var select = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setListener()
    }

    fun setListener () {
        var slotClick = listOf<TextView>(findViewById(R.id.park1) , findViewById(R.id.park2) , findViewById(R.id.park3))
        for (i in slotClick) {
            i.setOnClickListener{
                fectInfo(i)
            }
        }
        findViewById<Button>(R.id.buttonInput).setOnClickListener{setInfo()}
        findViewById<Button>(R.id.buttonRemove).setOnClickListener{deleteInfo()}
    }
    fun fectInfo(view: TextView){

        select = view.id.toString()
        //Toast.makeText(this , selectSlot , Toast.LENGTH_SHORT).show()
        checkSlot()
        when(view.id){
            R.id.park1 -> {
                findViewById<TextView>(R.id.inputCarnumber).requestFocus()
                findViewById<TextView>(R.id.inputCarnumber).text = parking.get(0).numberCar
                findViewById<TextView>(R.id.inputName).text = parking.get(0).name
                findViewById<TextView>(R.id.inputTypeCar).text = parking.get(0).typeCar
            }
            R.id.park2 -> {
                findViewById<TextView>(R.id.inputCarnumber).requestFocus()
                findViewById<TextView>(R.id.inputCarnumber).text = parking.get(1).numberCar
                findViewById<TextView>(R.id.inputName).text = parking.get(1).name
                findViewById<TextView>(R.id.inputTypeCar).text = parking.get(1).typeCar
            }
            R.id.park3 -> {
                findViewById<TextView>(R.id.inputCarnumber).requestFocus()
                findViewById<TextView>(R.id.inputCarnumber).text = parking.get(2).numberCar
                findViewById<TextView>(R.id.inputName).text = parking.get(2).name
                findViewById<TextView>(R.id.inputTypeCar).text = parking.get(2).typeCar
            }
        }
    }

    fun checkSlot() {
        for ( i in 0..parking.size-1){
            if(parking[i].name != "Empty"){
                if(i == 0){
                    findViewById<TextView>(R.id.park1).text = "Full"
                }else if(i == 1) {
                    findViewById<TextView>(R.id.park2).text = "Full"
                }else if(i == 2){
                    findViewById<TextView>(R.id.park3).text = "Full"
                }
            }else{
                if(i == 0){
                    findViewById<TextView>(R.id.park1).text = "Empty"
                }else if(i == 1) {
                    findViewById<TextView>(R.id.park2).text = "Empty"
                }else if(i == 2) {
                    findViewById<TextView>(R.id.park3).text = "Empty"
                }
            }
        }
    }

    fun selected() : Boolean {
        if(select == ""){
            return false
        }else{
            return true
        }
    }
    fun checkInput() : Boolean {
        var slotClick = listOf<TextView>(findViewById(R.id.inputName) , findViewById(R.id.inputCarnumber) , findViewById(R.id.inputTypeCar))
        var flag = true
        for (i in slotClick){
            if(i.text.toString() == ""){
                flag = false
                break
            }
        }

        return flag
    }



    fun setInfo () {
        if(selected()){
            if(checkInput()){
                when (select){
                    R.id.park1.toString() -> {
                        parking[0].name = findViewById<TextView>(R.id.inputName).text.toString()
                        parking[0].numberCar = findViewById<TextView>(R.id.inputCarnumber).text.toString()
                        parking[0].typeCar = findViewById<TextView>(R.id.inputTypeCar).text.toString()
                    }
                    R.id.park2.toString() -> {
                        parking[1].name = findViewById<TextView>(R.id.inputName).text.toString()
                        parking[1].numberCar = findViewById<TextView>(R.id.inputCarnumber).text.toString()
                        parking[1].typeCar = findViewById<TextView>(R.id.inputTypeCar).text.toString()
                    }
                    R.id.park3.toString() -> {
                        parking[2].name = findViewById<TextView>(R.id.inputName).text.toString()
                        parking[2].numberCar = findViewById<TextView>(R.id.inputCarnumber).text.toString()
                        parking[2].typeCar = findViewById<TextView>(R.id.inputTypeCar).text.toString()
                    }
                }
                clearTextInput()
                Toast.makeText(this , "Successes " , Toast.LENGTH_SHORT).show()
                checkSlot()
                select = ""
            }else{
                Toast.makeText(this , "Please fill all in put text. " , Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this , "Please select parking slot." , Toast.LENGTH_SHORT).show()
        }
    }
    fun clearTextInput() {
        var input = listOf<TextView>(findViewById(R.id.inputCarnumber) , findViewById(R.id.inputName) , findViewById(R.id.inputTypeCar))
        for (i in input){
            i.text = ""
        }
    }
    fun deleteInfo() {
        when(select){

            R.id.park1.toString() ->{
                parking[0].numberCar = "Empty"
                parking[0].name = "Empty"
                parking[0].typeCar = "Empty"
            }
            R.id.park2.toString() ->{
                parking[1].numberCar = "Empty"
                parking[1].name = "Empty"
                parking[1].typeCar = "Empty"
            }
            R.id.park3.toString() ->{
                parking[2].numberCar = "Empty"
                parking[2].name = "Empty"
                parking[2].typeCar = "Empty"
            }

        }
        checkSlot()
        clearTextInput()
    }








}
