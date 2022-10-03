package com.northsoltech.sign.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import com.northsoltech.framework.components.CustomButton
import com.northsoltech.framework.components.MainTitleText
import com.northsoltech.framework.states.UiState
import com.northsoltech.framework.ui.theming.Dimension
import com.northsoltech.sign.R
import com.northsoltech.sign.ui.signin.LoginViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    onUserAuthentcated:()->Unit,
    onUserAuthentcateFailed:(error:String)->Unit,
    onUserSignupListener:()->Unit
) {

    val uiState by remember { loginViewModel.uiState }
    var phoneNo by remember { mutableStateOf("") }
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
        MainTitleText(title = stringResource(com.northsoltech.framework.R.string.appname))
        Spacer(modifier = Modifier.height(Dimension.pagePadding.times(3)))
        OutlinedTextField(
            value = phoneNo,
            textStyle = TextStyle(
                color = MaterialTheme.colors.secondary
            ),
            label = {Text(text = stringResource(id = R.string.phone_number))},
            onValueChange = { phoneNo = it },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Person,
                    contentDescription = "phoneNo")
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
//                    viewModel.loginUser(email.text,
//                        getActivity.getString(R.string.jwt_token)
//                    )
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
            text = stringResource(id = com.northsoltech.sign.R.string.login),
            enabled = uiState !is UiState.Loading,
            textStyle = MaterialTheme.typography.button,
            onButtonClicked = {
                loginViewModel.userLogin(
                    phoneNo = phoneNo,
                    password = userPassword,
                    onUserAuthentcated = onUserAuthentcated,
                    onUserAuthentcateFailed = onUserAuthentcateFailed
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
        Spacer(modifier = Modifier.height(Dimension.pagePadding))
        CustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Dimension.pagePadding.times(2),
                    end = Dimension.pagePadding.times(2))
                .shadow(elevation = Dimension.zero,
                shape = MaterialTheme.shapes.small),
            padding = PaddingValues(Dimension.pagePadding.div(2)),
            buttonColor = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.secondary,
            text = stringResource(id = R.string.registration),
            enabled = uiState !is UiState.Loading,
            textStyle = MaterialTheme.typography.h6,
            onButtonClicked = onUserSignupListener,
        )
    }
}
