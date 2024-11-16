-- Do not remove this comment, it is part of this aura: Avg Total Heal
function()
    
    -- Defining basic variables
    local spellpower = GetSpellBonusHealing()
    local healing = (spellpower * 2.31) * 1.2 
    local auraMod = aura_env.mod or 1 
    -- Number of bounces
    local N = 4
    local ancestralreach = IsPlayerSpell(382732)
    -- Checking for talents that change Number of bounces
    if ancestralreach then N = N+1 end
    if ancestralreach then healing= healing *1.08 end
    local flow = IsPlayerSpell(382039)
    if flow then N = N+1 end
    -- Cheking for buffs that change Number of bounces
    local unleash =  C_UnitAuras.GetPlayerAuraBySpellID(73685)
    if unleash~=nil then N= N+1 end
    
    -- Diminishing Return
    local X = 0.3
    local hightide = C_UnitAuras.GetPlayerAuraBySpellID(288675)
    --Checking for buffs that anull the Diminishing Return
    if hightide~=nil then X=0 end
    local DR = ((1-X)*(1-(1-X)^N)/X + 1)
    if X==0 then DR = N end
    
    -- Critical Chance implememtation
    local crit = GetCritChance()
    crit = crit/100*2*DR
    
    -- Mastery Calculation Based on raid average %health value
    local playerZone = GetRealZoneText()
    local currentHealth = 0
    local maxHealth = 0
    --Checking for Avg %health value of the raid thanks to "Riketta"
    for i = 1, MAX_RAID_MEMBERS do
        local name, _, _, _, _, _, zone, online, isDead, role, _ = GetRaidRosterInfo(i)
        
        if online and not isDead and playerZone == zone and UnitGroupRolesAssigned(name) ~= "TANK" then
            currentHealth = currentHealth + UnitHealth(name)
            maxHealth = maxHealth + UnitHealthMax(name)
        end
    end
    
    if currentHealth == 0 then aura_env.currentRaidHealthStatus = 0
    else aura_env.currentRaidHealthStatus = currentHealth / maxHealth * 100 end
    -- Final Mastery calculations
    local mastery = GetMastery()
    mastery = mastery/100
    aura_env.currentRaidHealthStatus = (100-aura_env.currentRaidHealthStatus)/100
    local mast = (aura_env.currentRaidHealthStatus* (mastery))
    
    -- Calculus of the actual healing taking into acount Mastery healing diminishing return modifiers to the spell and crit
    
    healing = (1+mast) * healing * DR * auraMod * (1+crit) 
    aura_env.expected = healing
    
    return healing
end
-- Special thanks to Woliance and Petru for helping me on this WA <3

-- Do not remove this comment, it is part of this aura: Number of Targets
function()
    
    -- Defining basic variables
    local spellpower = GetSpellBonusHealing()
    local healing = (spellpower * 2.31) * 1.2 
    
    -- Number of bounces
    local N = 4
    local ancestralreach = IsPlayerSpell(382732)
    -- Checking for talents that change Number of bounces
    if ancestralreach then N = N+1 end
    if ancestralreach then healing= healing *1.08 end
    local flow = IsPlayerSpell(382039)
    if flow then N = N+1 end
    -- Cheking for buffs that change Number of bounces
    local unleash =  C_UnitAuras.GetPlayerAuraBySpellID(73685)
    if unleash~=nil then N= N+1 end
    
    
    
    return N
end
-- Special thanks to Woliance and Petru for helping me on this WA <3

-- Do not remove this comment, it is part of this aura: Bonus Healing
function()
    
    
    local auraMod = aura_env.mod or 1
    
    
    return (auraMod-1) *100
end