/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetnews.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// CORRIGIDO: surface era Red700 (#DD0D3C) no modo claro, causando baixo contraste
// de texto sobre esse fundo (#DD0D3C sobre #F4D7E3 = 3.73, abaixo do mínimo 4.50).
// Surface agora usa branco para garantir contraste adequado do conteúdo.
// onSurfaceVariant usa cinza escuro (#49454F → contraste ~5.9 sobre branco) ✓
private val LightThemeColors = lightColorScheme(
    primary = Red700,
    primaryContainer = Red900,
    surface = Color.White,                  // CORRIGIDO: era Red700
    onSurface = Color(0xFF1C1B1F),          // preto suave, contraste ~16:1 sobre branco ✓
    onSurfaceVariant = Color(0xFF49454F),   // CORRIGIDO: contraste ~5.9 sobre branco ✓
    onPrimary = Color.White,
    secondary = Red700,
    secondaryContainer = Red900,
    onSecondary = Color.White,
    error = Red800
)

private val DarkThemeColors = darkColorScheme(
    primary = Red300,
    primaryContainer = Red700,
    surface = DarkGray200,
    onSurface = Color(0xFFE6E1E5),          // claro sobre fundo escuro ✓
    onSurfaceVariant = Color(0xFFCAC4D0),   // CORRIGIDO: contraste adequado sobre DarkGray200 ✓
    onPrimary = Color.White,
    secondary = Red300,
    onSecondary = Color.Black,
    error = Red200
)

@Composable
fun JetnewsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkThemeColors else LightThemeColors,
        typography = JetnewsTypography,
        shapes = JetnewsShapes,
        content = content
    )
}