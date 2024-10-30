import android.widget.GridLayout
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import com.ht.pokedexandroid.R
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.ht.pokedexandroid.data.Pokemon
import com.ht.pokedexandroid.ui.theme.PokedexAndroidTheme
import androidx.compose.foundation.lazy.items

@OptIn(ExperimentalUnitApi::class)
@Composable
fun CardPokemon(pokemon:Pokemon = Pokemon()) {
    var maxHeight=100.dp;
    var imageHeight=80.dp;
    var paddingValue=15.dp;
    androidx.compose.material.Surface() {
        Column(modifier = Modifier
            .padding(2.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = pokemon.color)
            .fillMaxWidth()
            .height(maxHeight),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Column(modifier = Modifier.padding(paddingValue,paddingValue, 0.dp,0.dp)) {
                Text(
                    text = pokemon.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(12F, TextUnitType.Sp)
                )
                Text(text = pokemon.type,
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = TextUnit(10F, TextUnitType.Sp)
                )
            }
        }
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(0.dp,paddingValue, paddingValue, 0.dp)
            .height(imageHeight),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id =pokemon.image),
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.fillMaxHeight(),
                contentDescription ="ads" )
        }
    }


}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexAndroidTheme {
        var pokemonList = listOf(
            Pokemon(name = "Pikachu", type = "Electric",color = Color.Yellow, image = R.drawable.examplepokenom),
            Pokemon(name = "Charmander", type = "Fire",color = Color.Red    , image = R.drawable.examplepokenom),
            Pokemon(name = "Bulbasaur", type = "Grass",color = Color.Green, image = R.drawable.examplepokenom),
            Pokemon(name = "Squirtle", type = "Water", color = Color.Blue,image = R.drawable.examplepokenom),
            Pokemon(name = "Jigglypuff", type = "Fairy",color = Color.Magenta, image = R.drawable.examplepokenom)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            items(pokemonList) { pokemon ->
                CardPokemon(pokemon)
            }
        }
    }
}
