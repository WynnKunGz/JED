package com.cy4.jed.config;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.common.ForgeConfigSpec;

public class JEDConfig {
	public static final ForgeConfigSpec CLIENT_SPEC;

	static {
		ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
		setupConfig(configBuilder);
		CLIENT_SPEC = configBuilder.build();
	}
	
	public static ForgeConfigSpec.BooleanValue jeiIntegration;
	public static ForgeConfigSpec.ConfigValue<Float> tooltipActivationTime;
	public static ForgeConfigSpec.BooleanValue alwaysEnUs;
	public static ForgeConfigSpec.ConfigValue<List<? extends String>> excludedModIds;

	private static void setupConfig(ForgeConfigSpec.Builder builder) {
		// Integration Options
		builder.comment(" This category holds options to do with integrations with other mods");
		builder.push("Integration Options");
		jeiIntegration = builder
				.comment("Enables integration with JEI")
				.define("jei_integration", true);
		builder.pop();
		
		// UI Options
		builder.comment(" This category holds options to do with the user interface");
		builder.push("UI Options");
		tooltipActivationTime = builder
				.comment("The time required (ticks) to hold Shift for the tooltip to activate")
				.define("tooltip_activation_time", 20F);
		builder.pop();

		// Description Options
		builder.comment(" This category holds options to do with the descriptions themselves");
		builder.push("Description Options");
		alwaysEnUs = builder
				.comment("Wether the description should always be in English (US). This is the most likely translation to be available.")
				.define("always_en_us", false);
		excludedModIds = builder
				.comment("The following mod IDs will not load descriptions. To stop default descriptions from appearing, exclude 'jed'.")
				.defineList("excluded_mod_ids", Arrays.asList("examplemodid"), entry -> true);
		builder.pop();

	}
}
