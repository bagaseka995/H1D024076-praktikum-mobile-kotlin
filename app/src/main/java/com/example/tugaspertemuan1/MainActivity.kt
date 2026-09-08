package com.example.tugaspertemuan1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugaspertemuan1.ui.theme.TugasPertemuan1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasPertemuan1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InformatikaUnsoed(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TugasPertemuan1Theme {
        Greeting("Android")
    }
}

@Composable
fun InformatikaUnsoed(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Image(
            painter = painterResource(id = R.drawable.gedung_teknik),
            contentDescription = "Gedung F FT Unsoed",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Selamat datang di Informatika Unsoed,\n" +
                    "Fakultas Teknik\n" +
                    "Universitas Jenderal Soedirman",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center

        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Program studi Informatika di Universitas Jenderal Soedirman (Unsoed) berdiri di tahun 2008, berawal dari kebutuhan mendesak akan tenaga ahli di bidang teknologi informasi dan komunikasi." +
                    "Saat itu, perkembangan teknologi yang pesat di Indonesia dan dunia memerlukan adanya program pendidikan tinggi yang mampu mencetak lulusan dengan kompetensi tinggi di bidang informatika",
            textAlign = TextAlign.Justify,
        )

        Text(
            text = "ada tahun tersebut, Fakultas Sains dan Teknik (FST) Unsoed mengambil inisiatif untuk mendirikan Program Studi Informatika. Pembentukan program studi ini bertujuan untuk memenuhi tuntutan masyarakat dan industri yang membutuhkan tenaga profesional dalam bidang teknologi informasi. " +
                    "Kurikulum yang disusun dirancang untuk memberikan pendidikan berkualitas, menggabungkan aspek praktis dan teoritis dari informatika, seperti pemrograman, sistem informasi, jaringan komputer, dan kecerdasan buatan.",
            textAlign = TextAlign.Justify
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = {
//                    TODO
                }
            ) {
                Text("NEXT")
            }
        }
    }
}