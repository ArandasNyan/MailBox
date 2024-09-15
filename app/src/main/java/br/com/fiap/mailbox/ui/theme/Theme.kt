package br.com.fiap.mailbox.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Zinc50,
    secondary = Zinc300,
    tertiary = Zinc600,

    background = Zinc900,
    surface = Zinc800,
    onPrimary = Zinc200,
    onSecondary = Zinc400,
    onTertiary = Zinc900,
    onBackground = Zinc700,
    onSurface = Zinc500,

    primaryContainer = Blue500,
    tertiaryContainer = Zinc700
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,                                          // Cor primária usada em botões, ícones e elementos principais
    onPrimary = Color.White,                                     // Cor do texto e ícones sobre elementos que usam a cor primária
    primaryContainer = Color(0xFFD0BCFF),                  // Cor de fundo para contêineres ou botões primários
    onPrimaryContainer = Color(0xFF3E1B70),                // Cor do texto e ícones sobre elementos que usam o contêiner primário

    secondary = PurpleGrey40,                                    // Cor secundária usada em chips, indicadores e outros elementos de apoio
    onSecondary = Color.White,                                   // Cor do texto e ícones sobre elementos que usam a cor secundária
    secondaryContainer = Color(0xFFCCC2DC),                 // Cor de fundo para contêineres ou botões secundários
    onSecondaryContainer = Color(0xFF1F1A2F),               // Cor do texto e ícones sobre o contêiner secundário

    tertiary = Pink40,                                            // Cor terciária usada em variações de elementos interativos
    onTertiary = Color.White,                                    // Cor do texto e ícones sobre elementos que usam a cor terciária
    tertiaryContainer = Color(0xFFFFD8E4),                  // Cor de fundo para contêineres ou botões terciários
    onTertiaryContainer = Color(0xFF31101F),                // Cor do texto e ícones sobre o contêiner terciário

    background = Color(0xFFFFFBFE),                         // Cor de fundo usada em áreas amplas, como a tela ou uma seção
    onBackground = Color(0xFF1C1B1F),                       // Cor do texto sobre a cor de fundo

    surface = Color(0xFFFFFBFE),                            // Cor usada em superfícies como cartões, menus e diálogos
    onSurface = Color(0xFF1C1B1F),                          // Cor do texto e ícones sobre a superfície
    surfaceVariant = Color(0xFFE7E0EC),                     // Variante de cor para superfícies com leve elevação ou variação
    onSurfaceVariant = Color(0xFF49454F),                   // Cor do texto e ícones sobre a variante de superfície

    error = Color(0xFFB3261E),                              // Cor de erro usada em feedback de erros, como mensagens de validação
    onError = Color.White,                                       // Cor do texto e ícones sobre elementos de erro
    errorContainer = Color(0xFFF9DEDC),                     // Cor de fundo para contêineres de erro, como botões de erro
    onErrorContainer = Color(0xFF410E0B),                   // Cor do texto sobre o contêiner de erro

    outline = Color(0xFF79747E),                            // Cor usada para bordas e divisores
    outlineVariant = Color(0xFFCBC4D0),                     // Variante da cor de contorno para elementos mais sutis

    inverseOnSurface = Color(0xFFF4EFF4),                   // Cor usada em superfícies invertidas, como uma área escura
    inverseSurface = Color(0xFF313033),                     // Cor da superfície invertida em temas claros
    inversePrimary = Color(0xFFD0BCFF),                     // Cor primária invertida, usada para contrastar com temas escuros

    surfaceTint = Purple40,                                       // Cor de destaque aplicada em superfícies interativas, como botões ao serem pressionados
    scrim = Color(0xFF000000)                               // Cor usada em sobreposições, como em diálogos ou modais
)


@Composable
fun MailBoxTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}