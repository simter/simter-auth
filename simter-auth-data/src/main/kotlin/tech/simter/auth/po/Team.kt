package tech.simter.auth.po

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import tech.simter.auth.TEAM_TABLE
import tech.simter.auth.po.base.Actor
import tech.simter.auth.po.base.Branch
import tech.simter.auth.po.base.Organization
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit

/**
 * A number of people who do something together as a group.
 *
 * Its parent organization must be a [Company], [Department], [Team] or its a top [Team] without parent.
 * If its parent is a [Team] means this [Team] is a sub [Team].
 *
 * @author RJ
 */
@Table(TEAM_TABLE)
data class Team(
  @Id override val id: Long,
  override val status: Organization.Status,
  override val code: String,
  override val name: String,
  override val branch: Branch? = null,
  override val createOn: OffsetDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS)
) : Organization {
  override val type: Actor.Type
    get() = Actor.Type.Team
}