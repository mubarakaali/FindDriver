package com.northsoltech.sign.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SimCard
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.northsoltech.framework.components.CustomButton
import com.northsoltech.framework.components.MediumTitleText
import com.northsoltech.framework.states.UiState
import com.northsoltech.framework.ui.theming.BikeTheme
import com.northsoltech.framework.ui.theming.Dimension
import com.northsoltech.sign.R
import com.northsoltech.sign.ui.signup.SignupViewModel

@Preview
@Composable
fun PreviewSignupScreen() {
    BikeTheme {
        SignupScreen(
            onUserAuthentcated = {

            },
            onUserAuthentcateFailed = {

            })
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignupScreen(
    signupViewModel: SignupViewModel? = null,
    onUserAuthentcated: () -> Unit,
    onUserAuthentcateFailed: (error: String) -> Unit,
) {

    val uiState by remember { signupViewModel!!.uiState }
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var cnicNumber by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current
    var isVisible by remember { mutableStateOf(false) }

    val icon = if (isVisible)
        painterResource(id = R.drawable.ic_baseline_visibility_24)
    else
        painterResource(id = R.drawable.ic_baseline_visibility_off_24)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(Dimension.pagePadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MediumTitleText(title = stringResource(R.string.registration))
        Spacer(modifier = Modifier.height(Dimension.pagePadding.times(3)))

        OutlinedTextField(
            value = name,
            textStyle = TextStyle(
                color = MaterialTheme.colors.secondary
            ),
            onValueChange = { name = it },
            label = { Text(text = stringResource(id = R.string.name)) },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Person,
                    contentDescription = "name")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onNext = {
//                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )
        Spacer(modifier = Modifier.height(Dimension.pagePadding))
        OutlinedTextField(
            value = phoneNumber,
            textStyle = TextStyle(
                color = MaterialTheme.colors.secondary
            ),
            onValueChange = { phoneNumber = it },
            label = { Text(text = stringResource(id = R.string.phone_number)) },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Call,
                    contentDescription = "call")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Phone
            ),
            keyboardActions = KeyboardActions(
                onNext = {
//                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )
        Spacer(modifier = Modifier.height(Dimension.pagePadding))
        OutlinedTextField(
            value = cnicNumber,
            textStyle = TextStyle(
                color = MaterialTheme.colors.secondary
            ),
            onValueChange = { cnicNumber = it },
            label = { Text(text = stringResource(id = R.string.cnic)) },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.SimCard,
                    contentDescription = "call")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(
                onNext = {
//                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )
        Spacer(modifier = Modifier.height(Dimension.pagePadding))

        OutlinedTextField(
            value = userPassword,
            textStyle = TextStyle(
                color = MaterialTheme.colors.secondary
            ),
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Lock,
                    contentDescription = "lock")
            },
            onValueChange = { userPassword = it },
            label = { Text(text = "Password") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = {
                    keyboardController?.hide()
                }
            ),
            trailingIcon = {
                IconButton(onClick = {
                    isVisible = !isVisible
                }) {
                    Icon(painter = icon,
                        contentDescription = "view password")
                }
            },
            visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(Dimension.pagePadding.times(2)))

        CustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Dimension.pagePadding.times(2),
                    end = Dimension.pagePadding.times(2))
                .shadow(
                    elevation = if (uiState !is UiState.Loading) Dimension.elevation else Dimension.zero,
                    shape = MaterialTheme.shapes.large,
                ),
            shape = MaterialTheme.shapes.large,
            padding = PaddingValues(Dimension.pagePadding.div(2)),
            buttonColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary,
            text = stringResource(id = R.string.signup),
            enabled = uiState !is UiState.Loading,
            textStyle = MaterialTheme.typography.button,
            onButtonClicked = {
                signupViewModel?.onSignUp(
                    name = name,
                    phoneNo = phoneNumber,
                    cnicNumber = cnicNumber,
                    password = userPassword,
                    onUserAuthenticated = onUserAuthentcated,
                    onUserAuthenticateFailed = onUserAuthentcateFailed
                )
            },
            leadingIcon = {
                if (uiState is UiState.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(end = Dimension.pagePadding)
                            .size(Dimension.smIcon),
                        color = MaterialTheme.colors.onPrimary,
                        strokeWidth = Dimension.xs
                    )
                }
            }
        )
    }
}
