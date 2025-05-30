package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.core.data.models.job.EmploymentType

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AdvancedSearchBottomSheet(
    filters: JobSearchFilters,
    onFiltersChange: (JobSearchFilters) -> Unit,
    onApply: () -> Unit,
    onClear: () -> Unit,
    onDismiss: () -> Unit
) {
    var localFilters by remember { mutableStateOf(filters) }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Advanced Filters",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }

        // Location Filter
        item {
            OutlinedTextField(
                value = localFilters.location,
                onValueChange = { localFilters = localFilters.copy(location = it) },
                label = { Text("Location") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(Icons.Default.LocationOn, contentDescription = null)
                }
            )
        }

        // Job Type Filter
        item {
            FilterSection(title = "Job Type") {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    EmploymentType.values().forEach { type ->
                        FilterChip(
                            selected = localFilters.jobTypes.contains(type),
                            onClick = {
                                localFilters = if (localFilters.jobTypes.contains(type)) {
                                    localFilters.copy(jobTypes = localFilters.jobTypes - type)
                                } else {
                                    localFilters.copy(jobTypes = localFilters.jobTypes + type)
                                }
                            },
                            label = { Text(type.name.replace("_", " ").lowercase().capitalize()) }
                        )
                    }
                }
            }
        }

        // Salary Range Filter
        item {
            FilterSection(title = "Salary Range") {
                var salaryRange by remember {
                    mutableStateOf(
                        (localFilters.salaryMin ?: 0.0).toFloat()..(localFilters.salaryMax ?: 100000.0).toFloat()
                    )
                }

                Column {
                    RangeSlider(
                        value = salaryRange,
                        onValueChange = {
                            salaryRange = it
                            localFilters = localFilters.copy(
                                salaryMin = it.start.toDouble(),
                                salaryMax = it.endInclusive.toDouble()
                            )
                        },
                        valueRange = 0f..200000f,
                        steps = 19
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("N$${salaryRange.start.toInt()}")
                        Text("N$${salaryRange.endInclusive.toInt()}")
                    }
                }
            }
        }

        // Experience Level Filter
        item {
            FilterSection(title = "Experience Level") {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ExperienceLevel.values().forEach { level ->
                        FilterChip(
                            selected = localFilters.experience == level,
                            onClick = {
                                localFilters = localFilters.copy(
                                    experience = if (localFilters.experience == level) null else level
                                )
                            },
                            label = { Text(level.name.replace("_", " ").lowercase().capitalize()) }
                        )
                    }
                }
            }
        }

        // Skills Filter
        item {
            FilterSection(title = "Required Skills") {
                var skillInput by remember { mutableStateOf("") }

                Column {
                    OutlinedTextField(
                        value = skillInput,
                        onValueChange = { skillInput = it },
                        label = { Text("Add skill") },
                        modifier = Modifier.fillMaxWidth(),
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    if (skillInput.isNotBlank()) {
                                        localFilters = localFilters.copy(
                                            skills = localFilters.skills + skillInput.trim()
                                        )
                                        skillInput = ""
                                    }
                                }
                            ) {
                                Icon(Icons.Default.Add, contentDescription = "Add skill")
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        localFilters.skills.forEach { skill ->
                            AssistChip(
                                onClick = {
                                    localFilters = localFilters.copy(
                                        skills = localFilters.skills - skill
                                    )
                                },
                                label = { Text(skill) },
                                trailingIcon = {
                                    Icon(
                                        Icons.Default.Close,
                                        contentDescription = "Remove skill",
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }

        // Date Posted Filter
        item {
            FilterSection(title = "Date Posted") {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    DatePosted.values().forEach { date ->
                        FilterChip(
                            selected = localFilters.datePosted == date,
                            onClick = {
                                localFilters = localFilters.copy(datePosted = date)
                            },
                            label = { Text(date.name.replace("_", " ").lowercase().capitalize()) }
                        )
                    }
                }
            }
        }

        // Action Buttons
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedButton(
                    onClick = {
                        localFilters = JobSearchFilters()
                        onClear()
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Clear All")
                }

                Button(
                    onClick = {
                        onFiltersChange(localFilters)
                        onApply()
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Apply Filters")
                }
            }
        }
    }
}

@Composable
fun FilterSection(
    title: String,
    content: @Composable () -> Unit
) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        content()
    }
}