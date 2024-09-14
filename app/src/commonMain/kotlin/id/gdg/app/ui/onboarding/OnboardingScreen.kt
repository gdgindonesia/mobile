package id.gdg.app.ui.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope
import gdgindonesia.app.generated.resources.Res
import gdgindonesia.app.generated.resources.app_name
import gdgindonesia.app.generated.resources.common_continue
import gdgindonesia.app.generated.resources.ic_logo_gdg
import gdgindonesia.app.generated.resources.onboarding_choose_chapter
import gdgindonesia.app.generated.resources.onboarding_description
import id.gdg.chapter.model.ChapterModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel,
    navigateToMainScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier
            .padding(12.dp)
    ) {
        val (gdg, footer) = createRefs()

        gdgWordingContent(gdg)

        footerOnboardingContent(
            ref = footer,
            chapterList = viewModel.chapterList,
            onChapterSelected = {
                viewModel.setChapterId(it)
            },
            navigateToMainScreen = navigateToMainScreen
        )
    }
}

@Composable
fun ConstraintLayoutScope.gdgWordingContent(
    ref: ConstrainedLayoutReference,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .constrainAs(ref) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
    ) {
        Image(
            painter = painterResource(Res.drawable.ic_logo_gdg),
            contentDescription = null,
            modifier = modifier
                .width(48.dp)
                .padding(bottom = 18.dp)
        )

        Text(
            text = stringResource(Res.string.app_name),
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 32.sp
        )

        Text(
            text = stringResource(Res.string.onboarding_description),
            fontSize = 14.sp,
            lineHeight = 20.sp,
            modifier = modifier
                .fillMaxWidth(0.5f)
                .padding(top = 4.dp)
        )
    }
}

@Composable
fun ConstraintLayoutScope.footerOnboardingContent(
    ref: ConstrainedLayoutReference,
    chapterList: List<ChapterModel>,
    onChapterSelected: (Int) -> Unit,
    navigateToMainScreen: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var selectedChipId by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .constrainAs(ref) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
    ) {
        Text(
            text = stringResource(Res.string.onboarding_choose_chapter),
            fontSize = 14.sp,
            modifier = modifier.padding(bottom = 4.dp)
        )

        chapterListSelector(
            chapterList = chapterList,
            selectedItemId = selectedChipId
        ) {
            selectedChipId = it.id
            onChapterSelected(it.id)
        }

        AnimatedVisibility(selectedChipId > 0) {
            Button(
                modifier = modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
                    .height(48.dp),
                onClick = { navigateToMainScreen() }
            ) {
                Text(stringResource(Res.string.common_continue))
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun chapterListSelector(
    modifier: Modifier = Modifier,
    chapterList: List<ChapterModel>,
    selectedItemId: Int?,
    onChapterSelected: (ChapterModel) -> Unit,
) {
    FlowRow(
        maxItemsInEachRow = 5,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        chapterList.forEach { item ->
            SelectableChip(
                item = item,
                isSelected = item.id == selectedItemId,
                onSelect = onChapterSelected
            )
        }
    }
}

@Composable
fun SelectableChip(
    item: ChapterModel,
    isSelected: Boolean,
    onSelect: (ChapterModel) -> Unit
) {
    AssistChip(
        onClick = { onSelect(item) },
        label = { Text(item.name) },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            labelColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
        )
    )
}