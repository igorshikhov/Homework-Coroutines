package otus.homework.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val diContainer = DiContainer()
    private val catsViewModel = CatsViewModelFactory(diContainer.service, diContainer.serviceCatsImage).create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = layoutInflater.inflate(R.layout.activity_main, null) as CatsView
        setContentView(view)

        findViewById<Button>(R.id.button).setOnClickListener {
            catsViewModel.getCatsViewData()
        }

        catsViewModel.catsLiveData.observe(this) {
            result ->
            when (result) {
                is Result.Success -> view.populate(result.fact)
                is Result.Error -> view.showError(result.errorMessage)
            }
        }
    }
}
