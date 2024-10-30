package com.ht.pokedexandroid.pages

import CardPokemon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import com.ht.pokedexandroid.ui.theme.PokedexAndroidTheme
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.material.Text
import com.ht.pokedexandroid.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.ht.pokedexandroid.data.Pokemon
import com.ht.pokedexandroid.ui.theme.*

var pokemonList = listOf(
    Pokemon(name = "Pikachu", type = "Electric",color = Electric, image = R.drawable.examplepokenom),
    Pokemon(name = "Charmander", type = "Fire",color = Fire   , image = R.drawable.examplepokenom),
    Pokemon(name = "Bulbasaur", type = "Grass",color = Grass, image = R.drawable.examplepokenom),
    Pokemon(name = "Jigglypuff", type = "Fairy",color = Fairy, image = R.drawable.examplepokenom)
)

@OptIn(ExperimentalFoundationApi::class, ExperimentalUnitApi::class)
@Composable
fun LandingPage() {
    Column(modifier = Modifier
        .padding(10.dp, 0.dp)
        .fillMaxSize()) {
        Row() {
            // Back + SearchBar
            Image(painter = painterResource(id = R.drawable.left_arrow), contentDescription = "back")
            Image(painter = painterResource(id = R.drawable.more), contentDescription = "menu")
        }
        Text(
            text = "Pokedex",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit(24F, TextUnitType.Sp),
            modifier = Modifier.padding(0.dp,10.dp,0.dp,10.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(pokemonList) { pokemon ->
                CardPokemon(pokemon)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexAndroidTheme {
        LandingPage()
    }
}
